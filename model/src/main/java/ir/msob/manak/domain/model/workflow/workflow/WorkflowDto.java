package ir.msob.manak.domain.model.workflow.workflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.manak.core.model.jima.domain.Dto;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@DtoInfo(serviceName = Workflow.DOMAIN_NAME_WITH_HYPHEN, version = "v1")
public class WorkflowDto extends Workflow implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843864469657000L;

    @Builder
    public WorkflowDto(String id) {
        super(id);
    }
}