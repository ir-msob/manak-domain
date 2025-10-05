package ir.msob.manak.domain.model.dms.documentspecification;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.ChildDomain;
import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import ir.msob.manak.core.model.jima.childdomain.characteristic.CharacteristicCriteria;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedAction;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedActionCriteria;
import ir.msob.manak.core.model.jima.domain.DomainAbstract;
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
@Document(collection = DocumentSpecification.DOMAIN_NAME)
@DomainInfo(serviceName = DocumentSpecification.DOMAIN_NAME_WITH_HYPHEN, version = "v1", domainName = DocumentSpecification.DOMAIN_NAME_WITH_HYPHEN)
public class DocumentSpecification extends DomainAbstract {
    @Serial
    private static final long serialVersionUID = -8938843863555452005L;

    @Transient
    public static final String DOMAIN_NAME = "DocumentSpecification";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "document-specification";

    @NotBlank
    private String name;
    private String description;
    private String key;
    /**
     * The type of document storage provider (e.g., MINIO, S3, GOOGLE_DRIVE, CONFLUENCE, OTHER, FTP)
     */
    @NotBlank
    private String storageType;

    @Singular
    @ChildDomain(cdClass = Characteristic.class, ccClass = CharacteristicCriteria.class)
    private SortedSet<Characteristic> characteristics = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = RelatedAction.class, ccClass = RelatedActionCriteria.class)
    private SortedSet<RelatedAction> relatedActions = new TreeSet<>();

    /**
     * Enum for field names (FN) for DocumentSpecification
     */
    public enum FN {
        name,
        description,
        key,
        storageType,
        characteristics,
        relatedActions
    }
}