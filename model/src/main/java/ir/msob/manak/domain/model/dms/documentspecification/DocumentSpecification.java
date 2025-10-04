package ir.msob.manak.domain.model.dms.documentspecification;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import ir.msob.manak.core.model.jima.childdomain.characteristic.CharacteristicCriteria;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedAction;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedActionCriteria;
import ir.msob.manak.core.model.jima.domain.DomainAbstract;
import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.ChildDomain;
import ir.msob.jima.core.commons.domain.DomainInfo;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.util.Map;
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

    @Singular
    @ChildDomain(cdClass = Characteristic.class, ccClass = CharacteristicCriteria.class)
    private SortedSet<Characteristic> characteristics = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = RelatedAction.class, ccClass = RelatedActionCriteria.class)
    private SortedSet<RelatedAction> relatedActions = new TreeSet<>();

    /**
     * The type of document storage provider (e.g., MINIO, S3, GOOGLE_DRIVE, CONFLUENCE, OTHER, FTP)
     */
    private StorageType storageType;
    /**
     * The endpoint URL of the storage service (e.g., https://minio.example.com)
     */
    private String endpoint;
    /**
     * The name of the bucket, container, or root folder for storage
     */
    private String bucketOrContainer;
    /**
     * The access key or username for connecting to the storage service
     */
    private String accessKey;
    /**
     * The secret key or password for connecting to the storage service
     */
    private String secretKey;
    /**
     * The region of the storage provider (if required, e.g., for S3)
     */
    private String region;
    /**
     * The base path for storing files in the service
     */
    private String basePath;
    /**
     * Custom and extensible properties for each provider (key-value pairs)
     */
    @Singular
    private java.util.Map<String, String> customProperties;

    /**
     * Enum for supported document storage providers.
     */
    public enum StorageType {
        /** MinIO object storage */
        MINIO,
        /** Amazon S3 or compatible object storage */
        S3,
        /** Google Drive cloud storage */
        GOOGLE_DRIVE,
        /** Atlassian Confluence attachment storage */
        CONFLUENCE,
        /** Other/Custom storage provider */
        OTHER,
        /** FTP server */
        FTP
    }

    /**
     * Enum for field names (FN) for DocumentSpecification
     */
    public enum FN {
        name,
        description,
        storageType,
        endpoint,
        bucketOrContainer,
        accessKey,
        secretKey,
        region,
        basePath,
        customProperties
    }

    /**
     * The access key or username for connecting to the storage service
     * @return accessKey (not serialized in JSON for security)
     */
    @JsonIgnore
    public String getAccessKey() {
        return accessKey;
    }

    /**
     * The secret key or password for connecting to the storage service
     * @return secretKey (not serialized in JSON for security)
     */
    @JsonIgnore
    public String getSecretKey() {
        return secretKey;
    }
}