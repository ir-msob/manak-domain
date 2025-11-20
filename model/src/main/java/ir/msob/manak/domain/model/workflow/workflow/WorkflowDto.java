package ir.msob.manak.domain.model.workflow.workflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidation;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedAction;
import ir.msob.manak.core.model.jima.domain.Dto;
import ir.msob.manak.domain.model.workflow.workflowspecification.WorkflowSpecification;
import lombok.*;

import java.io.Serial;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;

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
    public WorkflowDto(String id, WorkflowSpecification specification, String correlationId, WorkflowExecutionStatus executionStatus, String resultType, Instant startedAt, Instant endedAt, Map<String, Object> context, List<Cycle> cycles, int currentCycleNumber, String currentStage, Metrics metrics, List<AuditEvent> auditTrail, SortedSet<Characteristic> characteristics, SortedSet<ObjectValidation> objectValidations, SortedSet<RelatedAction> relatedActions) {
        super(id, specification, correlationId, executionStatus, resultType, startedAt, endedAt, context, cycles, currentCycleNumber, currentStage, metrics, auditTrail, characteristics, objectValidations, relatedActions);
    }
}