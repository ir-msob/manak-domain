package ir.msob.manak.domain.model.rms.dto;

import ir.msob.manak.domain.model.workflow.workflowspecification.WorkflowSpecification;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ScmSuccess implements ScmResult{
    private String message;
}
