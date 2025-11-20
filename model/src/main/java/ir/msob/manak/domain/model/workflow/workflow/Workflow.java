package ir.msob.manak.domain.model.workflow.workflow;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.ChildDomain;
import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import ir.msob.manak.core.model.jima.childdomain.characteristic.CharacteristicCriteria;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidation;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidationCriteria;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedAction;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedActionCriteria;
import ir.msob.manak.core.model.jima.domain.DomainAbstract;
import ir.msob.manak.domain.model.workflow.workflowspecification.WorkflowSpecification;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.time.Instant;
import java.util.*;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = Workflow.DOMAIN_NAME)
@DomainInfo(domainName = Workflow.DOMAIN_NAME_WITH_HYPHEN)
public class Workflow extends DomainAbstract {
    @Transient
    public static final String DOMAIN_NAME = "Workflow";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "workflow";
    @Serial
    private static final long serialVersionUID = -8938843863655473000L;
    @DBRef
    private WorkflowSpecification specification;
    private String correlationId;
    private WorkflowExecutionStatus executionStatus = WorkflowExecutionStatus.INITIALIZED;
    private String resultType;
    private Instant startedAt;
    private Instant endedAt;
    private Map<String, Object> context = new HashMap<>();
    @Singular
    private List<Cycle> cycles = new ArrayList<>();
    private int currentCycleNumber;
    private String currentStage;
    private Metrics metrics;
    private List<AuditEvent> auditTrail = new ArrayList<>();
    private List<WorkerHistory> workersHistory = new ArrayList<>();

    @Singular
    @ChildDomain(cdClass = Characteristic.class, ccClass = CharacteristicCriteria.class)
    private SortedSet<Characteristic> characteristics = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = ObjectValidation.class, ccClass = ObjectValidationCriteria.class)
    private SortedSet<ObjectValidation> objectValidations = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = RelatedAction.class, ccClass = RelatedActionCriteria.class)
    private SortedSet<RelatedAction> relatedActions = new TreeSet<>();

    public Workflow(String id, WorkflowSpecification specification, String correlationId, WorkflowExecutionStatus executionStatus, String resultType, Instant startedAt, Instant endedAt, Map<String, Object> context, List<Cycle> cycles, int currentCycleNumber, String currentStage, Metrics metrics, List<AuditEvent> auditTrail, SortedSet<Characteristic> characteristics, SortedSet<ObjectValidation> objectValidations, SortedSet<RelatedAction> relatedActions) {
        super(id);
        this.specification = specification;
        this.correlationId = correlationId;
        this.executionStatus = executionStatus;
        this.resultType = resultType;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.context = context;
        this.cycles = cycles;
        this.currentCycleNumber = currentCycleNumber;
        this.currentStage = currentStage;
        this.metrics = metrics;
        this.auditTrail = auditTrail;
        this.characteristics = characteristics;
        this.objectValidations = objectValidations;
        this.relatedActions = relatedActions;
    }

    public enum FN {
        name, description
    }

    public enum WorkflowExecutionStatus {
        INITIALIZED, IN_PROGRESS, COMPLETED
    }

    public enum CycleExecutionStatus {
        INITIALIZED, IN_PROGRESS, COMPLETED
    }

    public enum StageExecutionStatus {
        INITIALIZED, ERROR, SUCCESS
    }

    public enum WorkerExecutionStatus {
        ERROR, SUCCESS
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Cycle {
        private String id;
        private CycleExecutionStatus executionStatus = CycleExecutionStatus.INITIALIZED;
        private String trigger;
        private String cycleCategory;
        private Instant createdAt;
        private Map<String, Object> context = new HashMap<>();
        private List<StageHistory> stagesHistory = new ArrayList<>();
        private Instant finishedAt;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StageHistory {
        private String id;
        private String stageKey;
        private StageExecutionStatus executionStatus = StageExecutionStatus.INITIALIZED;
        private int attempt;
        private String workerId;
        private Map<String, Object> stageInput = new HashMap<>();
        private Map<String, Object> stageOutput = new HashMap<>();
        private Map<String, Object> error = new HashMap<>();
        private List<String> logs = new ArrayList<>();
        private Instant startedAt;
        private Instant endedAt;
        private long durationMs;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Metrics {
        private int totalCycles;
        private long avgCycleDurationMs;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AuditEvent {
        private Instant timestamp;
        private String eventType;
        private Map<String, Object> data = new HashMap<>();
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class WorkerHistory {
        private WorkerExecutionStatus executionStatus;
        private String error;
        private Instant timestamp;
    }
}