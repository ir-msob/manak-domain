package ir.msob.manak.domain.service.client;

import ir.msob.jima.crud.api.restful.client.domain.DomainCrudWebClient;
import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.domain.model.common.ServiceName;
import ir.msob.manak.domain.model.toolhub.dto.InvokeRequest;
import ir.msob.manak.domain.model.toolhub.dto.InvokeResponse;
import ir.msob.manak.domain.model.toolhub.dto.ToolRegistryDto;
import ir.msob.manak.domain.service.toolhub.util.ToolExecutorUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class ToolHubClient {

    private final DomainCrudWebClient domainCrudWebClient;
    private final WebClient webClient;

    public Flux<ToolRegistryDto> getStream(User user) {
        return this.webClient.get()
                .uri(builder -> builder
                        .host(ServiceName.TOOL_HUB)
                        .path("/api/v1/registry")
                        .build())
                .headers(headers -> domainCrudWebClient.setDefaultHeaders(headers, user))
                .retrieve()
                .bodyToFlux(ToolRegistryDto.class)
                .doOnSubscribe(sub -> log.info("Requesting tool registry stream"))
                .doOnNext(tool -> log.debug("Received tool from registry stream: id={}", tool.getToolId()))
                .doOnComplete(() -> log.info("Completed receiving tool registry stream"))
                .doOnError(e -> log.error("Error while streaming tool registry: {}", e.getMessage(), e))
                .onErrorResume(e -> {
                    log.warn("Returning empty tool stream due to error: {}", e.getMessage());
                    return Flux.empty();
                });
    }

    public Mono<InvokeResponse> invoke(InvokeRequest dto, User user) {
        return this.webClient.post()
                .uri(builder -> builder
                        .host(ServiceName.TOOL_HUB)
                        .path("/api/v1/gateway/invoke")
                        .build())
                .headers(headers -> domainCrudWebClient.setDefaultHeaders(headers, user))
                .bodyValue(dto)
                .retrieve()
                .bodyToMono(InvokeResponse.class)
                .doOnSubscribe(sub -> log.info("Invoking tool via gateway: toolId={}, user={}", dto.getToolId(), user.getId()))
                .doOnSuccess(res -> log.info("Tool invocation successful: toolId={}, response={}", dto.getToolId(), res))
                .doOnError(e -> log.error("Error invoking tool via gateway: toolId={}, error={}", dto.getToolId(), e.getMessage(), e))
                .onErrorResume(e -> Mono.just(InvokeResponse.builder()
                        .requestId(dto.getRequestId())
                        .toolId(dto.getToolId())
                        .error(InvokeResponse.ErrorInfo.builder()
                                .stackTrace(Arrays.toString(e.getStackTrace()))
                                .details(dto.getParameters())
                                .code("EXECUTION_ERROR")
                                .message(ToolExecutorUtil.buildErrorResponse(dto.getToolId(), e))
                                .build())
                        .executedAt(Instant.now())
                        .build()));
    }
}
