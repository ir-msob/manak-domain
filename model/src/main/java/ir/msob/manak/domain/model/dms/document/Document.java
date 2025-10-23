package ir.msob.manak.domain.model.dms.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.ChildDomain;
import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import ir.msob.manak.core.model.jima.childdomain.characteristic.CharacteristicCriteria;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidation;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidationCriteria;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedAction;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedActionCriteria;
import ir.msob.manak.core.model.jima.childdomain.relatedobject.relateddomain.RelatedDomain;
import ir.msob.manak.core.model.jima.childdomain.relatedobject.relateddomain.RelatedDomainCriteria;
import ir.msob.manak.core.model.jima.domain.DomainAbstract;
import ir.msob.manak.domain.model.dms.document.attachment.Attachment;
import ir.msob.manak.domain.model.dms.document.attachment.AttachmentCriteria;
import ir.msob.manak.domain.model.dms.documentspecification.DocumentSpecification;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.io.Serial;
import java.util.Comparator;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Represents a document entity in the DMS (Document Management System).
 * Contains metadata, tags, specification, attachments, and related child domains.
 */
@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@org.springframework.data.mongodb.core.mapping.Document(collection = Document.DOMAIN_NAME)
@DomainInfo(serviceName = Document.DOMAIN_NAME_WITH_HYPHEN, version = "v1", domainName = Document.DOMAIN_NAME_WITH_HYPHEN)
public class Document extends DomainAbstract {
    @Serial
    private static final long serialVersionUID = -8938843863555452004L;

    @Transient
    public static final String DOMAIN_NAME = "Document";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "document";

    /**
     * The unique name of the document.
     */
    @NotBlank
    private String name;
    /**
     * The key of the document.
     */
    private String key;
    /**
     * The description of the document.
     */
    private String description;
    /**
     * Tags associated with the document.
     */
    @Singular
    private SortedSet<String> tags = new TreeSet<>();

    /**
     * The specification describing the storage and connection details for this document.
     */
    @DBRef(lazy = true)
    private DocumentSpecification specification;

    /**
     * Attachments related to this document.
     */
    @Singular
    @ChildDomain(cdClass = Attachment.class, ccClass = AttachmentCriteria.class)
    private SortedSet<Attachment> attachments = new TreeSet<>();

    /**
     * Characteristics of the document.
     */
    @Singular
    @ChildDomain(cdClass = Characteristic.class, ccClass = CharacteristicCriteria.class)
    private SortedSet<Characteristic> characteristics = new TreeSet<>();

    /**
     * Object validations for the document.
     */
    @Singular
    @ChildDomain(cdClass = ObjectValidation.class, ccClass = ObjectValidationCriteria.class)
    private SortedSet<ObjectValidation> objectValidations = new TreeSet<>();

    /**
     * Related actions for the document.
     */
    @Singular
    @ChildDomain(cdClass = RelatedAction.class, ccClass = RelatedActionCriteria.class)
    private SortedSet<RelatedAction> relatedActions = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = RelatedDomain.class, ccClass = RelatedDomainCriteria.class)
    private SortedSet<RelatedDomain> relatedDomains = new TreeSet<>();

    public enum FN {
        name, description, tags, attachments, characteristics, objectValidations, relatedActions, relatedDomains
    }

    public enum RelatedDomainRole {
        PRIMARY, SECONDARY
    }

    public Optional<Attachment> getLatestAttachment() {
        if (attachments == null || attachments.isEmpty()) {
            return Optional.empty();
        }

        return attachments.stream()
                .max(Comparator.comparingInt(Attachment::getVersion));
    }

}