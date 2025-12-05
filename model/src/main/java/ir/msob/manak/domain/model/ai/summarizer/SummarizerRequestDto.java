package ir.msob.manak.domain.model.ai.summarizer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.jima.core.commons.shared.ModelType;
import ir.msob.manak.domain.model.common.ServiceName;
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
@DtoInfo(serviceName = ServiceName.AI, version = "v1")
@DomainInfo(domainName = SummarizerRequestDto.DOMAIN_NAME_WITH_HYPHEN)
public class SummarizerRequestDto extends ModelType {

    @JsonIgnore
    public static final String DOMAIN_NAME_WITH_HYPHEN = "summarizer";

    private String requestId;
    private String model;


    private Long maxLength = 150L;
    private Long minLength = 50L;

    private String outputLanguage = "auto"; // fa, en, auto
    private Double temperature = 0.2;
    private Double topP = 1.0;

    @NotEmpty
    @Singular
    private List<String> inputs = new ArrayList<>();
    private SummaryType type = SummaryType.COMBINED;
    private SummaryStyle style = SummaryStyle.DEFAULT;

    public enum SummaryType {
        PER_INPUT,
        COMBINED,
        HIERARCHICAL
    }

    public enum SummaryStyle {
        DEFAULT,
        BULLET_POINTS,
        ABSTRACT,
        OVERVIEW,
        KEY_POINTS,
        TITLE_ONLY
    }

}
