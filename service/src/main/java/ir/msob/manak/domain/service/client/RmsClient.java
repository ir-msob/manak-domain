package ir.msob.manak.domain.service.client;

import ir.msob.jima.core.commons.logger.Logger;
import ir.msob.jima.core.commons.logger.LoggerFactory;
import ir.msob.jima.crud.api.restful.client.domain.DomainCrudWebClient;
import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.domain.model.common.ServiceName;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class RmsClient {

    private final Logger logger = LoggerFactory.getLogger(RmsClient.class);
    private final DomainCrudWebClient domainCrudWebClient;
    private final WebClient webClient;


    public Flux<DataBuffer> downloadBranch(String id, @Nullable String branch, User user) {
        return this.webClient.get()
                .uri(builder -> builder
                        .host(ServiceName.DMS)
                        .path(branch == null ?
                                "/api/v1/repository/{id}/download" :
                                "/api/v1/repository/{id}/branch/{branch}/download")
                        .build(id, branch))
                .headers(headers -> domainCrudWebClient.setDefaultHeaders(headers, user))
                .retrieve()
                .bodyToFlux(DataBuffer.class)
                .doOnSubscribe(sub -> logger.info("Downloading ZIP from DMS. id={}, branch={}", id, branch))
                .doOnError(e -> logger.error("Failed to download ZIP. id={}, branch={}, error={}", id, branch, e.getMessage(), e));
    }
}
