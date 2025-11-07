package ir.msob.manak.domain.model.project.project;

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
@DtoInfo(serviceName = ServiceName.PROJECT, version = "v1")
public class ProjectDto extends Project implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843863578919000L;

    @Builder
    public ProjectDto(String id, String name, String description) {
        super(id, name, description);
    }

}