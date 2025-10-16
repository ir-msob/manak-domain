package ir.msob.manak.domain.model.git.gitspecification;

import ir.msob.manak.core.model.jima.domain.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GitSpecificationDto extends GitSpecification implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843863894681000L;

    @Builder
    public GitSpecificationDto(String id, String name, String description) {
        super(id, name, description);
    }

}