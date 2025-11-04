package ir.msob.manak.domain.service.toolhub;

import ir.msob.jima.core.commons.logger.Logger;
import ir.msob.jima.core.commons.logger.LoggerFactory;
import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.domain.model.toolhub.ToolExecutor;
import ir.msob.manak.domain.model.toolhub.dto.InvokeRequest;
import ir.msob.manak.domain.model.toolhub.dto.InvokeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ToolService {

    private static final Logger log = LoggerFactory.getLogger(ToolService.class);
    private final ToolExecutorRegistry toolExecutorRegistry;

    public Mono<InvokeResponse> invoke(InvokeRequest request, User user) {
        String toolId = request.getToolId();
        log.debug("Invoking tool with ID: {}", toolId);

        ToolExecutor executor = toolExecutorRegistry.getExecutorMap() == null ?
                null : toolExecutorRegistry.getExecutorMap().get(toolId);
        if (executor == null) {
            log.warn("No ToolExecutor found for toolId '{}'", toolId);
            return Mono.just(InvokeResponse.builder()
                    .toolId(toolId)
                    .error("Unsupported tool: " + toolId)
                    .build()
            );
        }

        return executor.execute(request, user)
                .doOnSubscribe(sub -> log.info("Executing tool '{}'", toolId))
                .doOnSuccess(resp -> log.info("Tool '{}' executed successfully", toolId))
                .doOnError(err -> log.error("Error executing tool '{}': {}", toolId, err.getMessage(), err))
                .onErrorResume(e -> Mono.just(
                        InvokeResponse.builder()
                                .toolId(toolId)
                                .error(ToolExecutorUtl.buildErrorResponse(toolId, e))
                                .build()
                ));
    }
}
