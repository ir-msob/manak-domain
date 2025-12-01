package ir.msob.manak.domain.model.chat.modelspecification;

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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@Document(collection = ModelSpecification.DOMAIN_NAME)
@DomainInfo(domainName = ModelSpecification.DOMAIN_NAME_WITH_HYPHEN)
public class ModelSpecification extends DomainAbstract {
    @Transient
    public static final String DOMAIN_NAME = "ModelSpecification";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "model-specification";
    @Serial
    private static final long serialVersionUID = -8938843865454313000L;
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String key;
    @NotBlank
    private String modelName;
    @NotBlank
    private String baseUrl;
    @NotBlank
    private String providerType;
    @Singular
    @NotEmpty
    private List<ModelType> modelTypes = new ArrayList<>();
    private Double temperature;
    private Integer numPredict;

    @Singular
    @ChildDomain(cdClass = Characteristic.class, ccClass = CharacteristicCriteria.class)
    private SortedSet<Characteristic> characteristics = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = ObjectValidation.class, ccClass = ObjectValidationCriteria.class)
    private SortedSet<ObjectValidation> objectValidations = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = RelatedAction.class, ccClass = RelatedActionCriteria.class)
    private SortedSet<RelatedAction> relatedActions = new TreeSet<>();

    public ModelSpecification(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public enum ModelType {
        TOOLS, THINKING, EMBEDDING, CHAT
    }
}