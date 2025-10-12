package ir.msob.manak.domain.model.project.project;

import ir.msob.manak.core.model.jima.domain.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectDto extends Project implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843863578919000L;

    @Builder
    public ProjectDto(String id, String name, String description) {
        super(id, name, description);
    }

}