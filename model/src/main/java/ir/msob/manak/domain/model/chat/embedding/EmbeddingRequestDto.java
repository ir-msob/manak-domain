package ir.msob.manak.domain.model.chat.embedding;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.jima.core.commons.shared.ModelType;
import ir.msob.manak.domain.model.common.ServiceName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@DtoInfo(serviceName = ServiceName.CHAT, version = "v1")
@DomainInfo(domainName = EmbeddingRequestDto.DOMAIN_NAME_WITH_HYPHEN)
public class EmbeddingRequestDto extends ModelType {
    @JsonIgnore
    public static final String DOMAIN_NAME_WITH_HYPHEN = "embedding";

    private String requestId;
    private String model;

    @NotEmpty
    @Singular
    private List<String> inputs = new ArrayList<>();
    private EmbeddingOptions options;

}