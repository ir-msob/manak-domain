package ir.msob.manak.domain.model.workflow.stage;

import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.manak.core.model.jima.domain.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@DtoInfo(serviceName = Stage.DOMAIN_NAME_WITH_HYPHEN, version = "v1")
public class StageDto extends Stage implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843864926260000L;

    @Builder
    public StageDto(String id, String name, String description) {
        super(id, name, description);
    }

}