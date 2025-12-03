package ir.msob.manak.domain.service.client;

import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.jima.crud.api.restful.client.RestUtil;
import ir.msob.manak.domain.model.ai.chat.ChatRequestDto;
import ir.msob.manak.domain.model.ai.embedding.EmbeddingRequestDto;
import ir.msob.manak.domain.model.ai.embedding.EmbeddingResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AiClient {
    private final WebClient webClient;

    public Mono<String> chat(ChatRequestDto chatRequestDto) {
        DomainInfo domainInfo = DomainInfo.info.getAnnotation(chatRequestDto.getClass());
        DtoInfo dtoInfo = DtoInfo.info.getAnnotation(chatRequestDto.getClass());
        return webClient.post()
                .uri(builder -> builder.host(dtoInfo.serviceName())
                        .path(RestUtil.uri(dtoInfo, domainInfo)).build())
                .bodyValue(chatRequestDto)
                .retrieve()
                .bodyToMono(String.class);
    }

    public Mono<EmbeddingResponseDto> embedding(EmbeddingRequestDto embeddingRequestDto) {
        DomainInfo domainInfo = DomainInfo.info.getAnnotation(embeddingRequestDto.getClass());
        DtoInfo dtoInfo = DtoInfo.info.getAnnotation(embeddingRequestDto.getClass());
        return webClient.post()
                .uri(builder -> builder.host(dtoInfo.serviceName())
                        .path(RestUtil.uri(dtoInfo, domainInfo)).build())
                .bodyValue(embeddingRequestDto)
                .retrieve()
                .bodyToMono(EmbeddingResponseDto.class);
    }
}