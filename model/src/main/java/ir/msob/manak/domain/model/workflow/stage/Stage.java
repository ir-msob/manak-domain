package ir.msob.manak.domain.model.workflow.stage;

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
import ir.msob.manak.domain.model.common.model.ParameterDescriptor;
import ir.msob.manak.domain.model.common.model.RetryPolicy;
import ir.msob.manak.domain.model.workflow.workflowspecification.WorkflowSpecification;
import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = Stage.DOMAIN_NAME)
@DomainInfo(domainName = Stage.DOMAIN_NAME_WITH_HYPHEN)
public class Stage extends DomainAbstract {
    @Transient
    public static final String DOMAIN_NAME = "Stage";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "stage";
    @Serial
    private static final long serialVersionUID = -8938843863635655000L;
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String key;
    @NotNull
    private Type type;
    private Map<String, Object> context = new HashMap<>();
    private ParameterDescriptor inputSchema;
    private ParameterDescriptor outputSchema;
    private RetryPolicy retryPolicy;
    private Long timeoutMs;

    @Singular
    @ChildDomain(cdClass = Characteristic.class, ccClass = CharacteristicCriteria.class)
    private SortedSet<Characteristic> characteristics = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = ObjectValidation.class, ccClass = ObjectValidationCriteria.class)
    private SortedSet<ObjectValidation> objectValidations = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = RelatedAction.class, ccClass = RelatedActionCriteria.class)
    private SortedSet<RelatedAction> relatedActions = new TreeSet<>();

    public Stage(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public enum FN {
        name, description
    }

    public enum Type {
        USER_TASK, SYSTEM_ACTION, AI_EXECUTION
    }
}