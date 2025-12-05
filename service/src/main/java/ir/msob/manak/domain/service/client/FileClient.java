package ir.msob.manak.domain.service.client;

import ir.msob.jima.core.commons.logger.Logger;
import ir.msob.jima.core.commons.logger.LoggerFactory;
import ir.msob.jima.crud.api.restful.client.domain.DomainCrudWebClient;
import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.domain.model.common.ServiceName;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class FileClient {

    private final Logger logger = LoggerFactory.getLogger(FileClient.class);
    private final DomainCrudWebClient domainCrudWebClient;
    private final WebClient webClient;

    /**
     * Downloads a file from DMS and returns the file as InputStreamResource.
     */
    public Mono<InputStreamResource> downloadFile(String filePath, User user) {
        return this.webClient.get()
                .uri(builder -> builder
                        .host(ServiceName.DMS)
                        .path("/api/v1/file/")
                        .pathSegment(filePath)
                        .build())
                .headers(headers -> domainCrudWebClient.setDefaultHeaders(headers, user))
                .retrieve()
                .bodyToMono(InputStreamResource.class)
                .doOnSubscribe(sub -> logger.info("Downloading file from DMS. filePath={}", filePath))
                .doOnSuccess(res -> logger.info("File downloaded successfully. filePath={}", filePath))
                .doOnError(e -> logger.error("Failed to download file. filePath={}, error={}", filePath, e.getMessage(), e));
    }

}
