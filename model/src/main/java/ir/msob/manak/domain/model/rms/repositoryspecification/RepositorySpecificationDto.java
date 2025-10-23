package ir.msob.manak.domain.model.rms.repositoryspecification;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.manak.core.model.jima.domain.Dto;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RepositorySpecificationDto extends RepositorySpecification implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843865372202000L;

    @Builder
    public RepositorySpecificationDto(String id, String name, String description) {
        super(id, name, description);
    }

}