package ir.msob.manak.domain.model.rms.repositoryspecification;

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
@DtoInfo(serviceName = ServiceName.RMS, version = "v1")
public class RepositorySpecificationDto extends RepositorySpecification implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843865372202000L;

    @Builder
    public RepositorySpecificationDto(String id, String name, String description) {
        super(id, name, description);
    }

}