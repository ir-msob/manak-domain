package ir.msob.manak.domain.model.toolhub.toolprovider;

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
import ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor.ToolDescriptor;
import ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor.ToolDescriptorCriteria;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.util.SortedSet;
import java.util.TreeSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = ToolProvider.DOMAIN_NAME)
@DomainInfo(serviceName = "toolhub", version = "v1", domainName = ToolProvider.DOMAIN_NAME_WITH_HYPHEN)
public class ToolProvider extends DomainAbstract {
    @Transient
    public static final String DOMAIN_NAME = "ToolProvider";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "tool-provider";
    @Serial
    private static final long serialVersionUID = -8938843865017759000L;
    @NotBlank
    private String name;
    private String description;
    private String serviceName;
    private String serviceUrl;
    @NotBlank
    private String endpoint;

    @Singular
    @ChildDomain(cdClass = ToolDescriptor.class, ccClass = ToolDescriptorCriteria.class)
    private SortedSet<ToolDescriptor> tools = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = Characteristic.class, ccClass = CharacteristicCriteria.class)
    private SortedSet<Characteristic> characteristics = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = ObjectValidation.class, ccClass = ObjectValidationCriteria.class)
    private SortedSet<ObjectValidation> objectValidations = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = RelatedAction.class, ccClass = RelatedActionCriteria.class)
    private SortedSet<RelatedAction> relatedActions = new TreeSet<>();

    public enum FN {
        name, description, serviceName, serviceUrl, endpoint
    }
}