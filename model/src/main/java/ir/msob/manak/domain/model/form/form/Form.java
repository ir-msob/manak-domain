package ir.msob.manak.domain.model.form.form;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.ChildDomain;
import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import ir.msob.manak.core.model.jima.childdomain.characteristic.CharacteristicCriteria;
import ir.msob.manak.core.model.jima.childdomain.contactmedium.ContactMedium;
import ir.msob.manak.core.model.jima.childdomain.contactmedium.ContactMediumCriteria;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidation;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidationCriteria;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedAction;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedActionCriteria;
import ir.msob.manak.core.model.jima.domain.DomainAbstract;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.util.SortedSet;
import java.util.TreeSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = Form.DOMAIN_NAME)
@DomainInfo(serviceName = Form.DOMAIN_NAME_WITH_HYPHEN, version = "v1", domainName = Form.DOMAIN_NAME_WITH_HYPHEN)
public class Form extends DomainAbstract {
    @Transient
    public static final String DOMAIN_NAME = "Form";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "form";
    @Serial
    private static final long serialVersionUID = -8938843863557645000L;
    @NotBlank
    private String name;
    private String description;

    @ChildDomain(cdClass = Characteristic.class, ccClass = CharacteristicCriteria.class)
    private SortedSet<Characteristic> characteristics = new TreeSet<>();

    @ChildDomain(cdClass = ContactMedium.class, ccClass = ContactMediumCriteria.class)
    private SortedSet<ContactMedium> contactMediums = new TreeSet<>();

    @ChildDomain(cdClass = ObjectValidation.class, ccClass = ObjectValidationCriteria.class)
    private SortedSet<ObjectValidation> objectValidations = new TreeSet<>();

    @ChildDomain(cdClass = RelatedAction.class, ccClass = RelatedActionCriteria.class)
    private SortedSet<RelatedAction> relatedActions = new TreeSet<>();

    public Form(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public enum FN {
        name, description
    }
}