package ir.msob.manak.domain.model.rms.gitspecification;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.manak.core.model.jima.domain.Dto;
import ir.msob.manak.domain.model.common.ServiceName;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@DtoInfo(serviceName = ServiceName.RMS, version = "v1")
public class GitSpecificationDto extends GitSpecification implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843863894681000L;

    @Builder
    public GitSpecificationDto(String id, String name, String description) {
        super(id, name, description);
    }

}