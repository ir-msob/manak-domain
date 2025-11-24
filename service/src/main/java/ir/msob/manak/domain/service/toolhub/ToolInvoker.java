package ir.msob.manak.domain.service.toolhub;

import ir.msob.manak.core.service.jima.security.UserService;
import ir.msob.manak.domain.model.toolhub.dto.InvokeRequest;
import ir.msob.manak.domain.model.toolhub.dto.InvokeResponse;
import ir.msob.manak.domain.service.client.ToolHubClient;
import ir.msob.manak.domain.service.toolhub.util.ToolExecutorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

/**
 * Central executor for Tool invocations.
 * Supports both synchronous (blocking) and reactive execution models.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ToolInvoker {

    private final ToolHubClient toolHubClient;
    private final UserService userService;

    /**
     * Blocking invocation (e.g. REST call or other sync clients)
     */
    public InvokeResponse invoke(String toolId, Map<String, Object> params) throws ExecutionException, InterruptedException {
        return invokeReactive(toolId, params)
                .toFuture()
                .get();
    }

    /**
     * Reactive invocation (preferred for Camunda workers / reactive pipelines)
     */
    public Mono<InvokeResponse> invokeReactive(String toolId, Map<String, Object> params) {

        InvokeRequest request = createRequest(toolId, params);

        log.debug("Invoking tool '{}', requestId={}", toolId, request.getRequestId());

        return toolHubClient.invoke(request, userService.getSystemUser())
                .onErrorResume(error -> {
                    log.error("Tool Invocation Failed: toolId={}, requestId={}, reason={}",
                            toolId, request.getRequestId(), error.getMessage(), error);
                    return Mono.just(buildErrorResponse(request, error));
                })
                .doOnSuccess(response ->
                        log.debug("Tool Invocation Completed: toolId={}, requestId={}",
                                toolId, request.getRequestId())
                );
    }

    // ---------------------------------------------------------
    // Internal Helpers
    // ---------------------------------------------------------

    private InvokeRequest createRequest(String toolId, Map<String, Object> params) {
        return InvokeRequest.builder()
                .requestId(UUID.randomUUID().toString())
                .toolId(toolId)
                .parameters(params)
                .build();
    }

    private InvokeResponse buildErrorResponse(InvokeRequest request, Throwable e) {
        String formattedMessage = ToolExecutorUtil.buildErrorResponse(request.getToolId(), e);

        return InvokeResponse.builder()
                .requestId(request.getRequestId())
                .toolId(request.getToolId())
                .error(
                        InvokeResponse.ErrorInfo.builder()
                                .code("EXECUTION_ERROR")
                                .message(formattedMessage)
                                .stackTrace(Arrays.toString(e.getStackTrace()))
                                .details(request.getParameters())
                                .build()
                )
                .executedAt(Instant.now())
                .build();
    }

}
