package ir.msob.manak.domain.model.workflow.workflowspecification;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.manak.core.model.jima.domain.Dto;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@DtoInfo(serviceName = WorkflowSpecification.DOMAIN_NAME_WITH_HYPHEN, version = "v1")
public class WorkflowSpecificationDto extends WorkflowSpecification implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843865144998000L;

    @Builder
    public WorkflowSpecificationDto(String id, String name, String description) {
        super(id, name, description);
    }

}