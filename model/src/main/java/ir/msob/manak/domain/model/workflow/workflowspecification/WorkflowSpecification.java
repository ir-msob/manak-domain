package ir.msob.manak.domain.model.workflow.workflowspecification;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.ChildDomain;
import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.jima.core.commons.shared.auditinfo.AuditInfo;
import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import ir.msob.manak.core.model.jima.childdomain.characteristic.CharacteristicCriteria;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidation;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidationCriteria;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedAction;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedActionCriteria;
import ir.msob.manak.core.model.jima.domain.DomainAbstract;
import ir.msob.manak.domain.model.workflow.stage.Stage;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.util.*;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = WorkflowSpecification.DOMAIN_NAME)
@DomainInfo(domainName = WorkflowSpecification.DOMAIN_NAME_WITH_HYPHEN)
public class WorkflowSpecification extends DomainAbstract {

    @Transient
    public static final String DOMAIN_NAME = "WorkflowSpecification";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "workflow-specification";

    @Serial
    private static final long serialVersionUID = -8938843864444493000L;

    @NotBlank
    private String name;
    private String key;
    private String version;
    private String description;
    private String createdBy;
    private AuditInfo auditInfo;
    private List<String> resultTypes;
    @Singular
    private List<StageSpec> stages = new ArrayList<>();
    private Map<String, Object> context = new HashMap<>();
    private GlobalRetryPolicy globalRetryPolicy;
    private Hooks hooks;

    @Singular
    @ChildDomain(cdClass = Characteristic.class, ccClass = CharacteristicCriteria.class)
    private SortedSet<Characteristic> characteristics = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = ObjectValidation.class, ccClass = ObjectValidationCriteria.class)
    private SortedSet<ObjectValidation> objectValidations = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = RelatedAction.class, ccClass = RelatedActionCriteria.class)
    private SortedSet<RelatedAction> relatedActions = new TreeSet<>();

    public WorkflowSpecification(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public enum FN {
        name, description
    }

    /**
     * Updated Transition to support complex conditions
     */
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Transition {
        /**
         * Key = variable/expression (e.g. $workflowContext.field, $resultType)
         * Value = either:
         * - simple literal value (String/Number/Boolean)
         * - Map<String,Object> for operators: $in, $not, $exists, $regex, $gt, $gte, $lt, $lte
         */
        private Map<String, Object> on = new HashMap<>();
        private String goTo;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HumanTask {
        private String assignee;
        private long SlaSeconds;
        private boolean allowDelegate;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GlobalRetryPolicy {
        private int maxAttempts;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Hooks {
        private String onStageStart;
        private String onStageEnd;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StageSpec {
        @DBRef
        @NotNull
        private Stage stage;
        private boolean firstStage;

        @Singular("inputEntry")
        private Map<String, Object> inputMapping = new HashMap<>();

        @Singular("outputEntry")
        private Map<String, Object> outputMapping = new HashMap<>();

        @Singular
        private List<Transition> transitions = new ArrayList<>();

        private HumanTask humanTask;
    }
}
