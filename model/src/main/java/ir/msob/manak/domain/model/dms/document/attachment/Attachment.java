package ir.msob.manak.domain.model.dms.document.attachment;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.BaseChildDomainAbstract;
import ir.msob.jima.core.commons.shared.auditinfo.AuditInfo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.PersistenceCreator;

import java.util.Objects;

/**
 * Represents an attachment for a document in the DMS.
 * Contains file metadata, status, and audit information.
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Attachment extends BaseChildDomainAbstract<String> implements Comparable<Attachment> {
    /**
     * The file path where the attachment is stored.
     */
    @NotBlank
    private String filePath;
    /**
     * The status of the attachment (e.g., DRAFT, ACTIVE, DELETED, etc.).
     */
    @NotNull
    @Builder.Default
    private Status status = Status.CREATED;
    /**
     * The name of the file.
     */
    @NotBlank
    private String fileName;
    /**
     * The MIME type of the file.
     */
    @NotBlank
    private String mimeType;
    /**
     * The size of the file in bytes.
     */
    @NotNull
    private Long fileSize;
    /**
     * The checksum of the file for integrity verification.
     */
    private String checksum;
    /**
     * Audit information for the attachment (created/updated info).
     */
    @Builder.Default
    private AuditInfo auditInfo = AuditInfo.builder().build();
    /**
     * The order of the attachment among other attachments. Default is 0.
     */
    @Builder.Default
    private Integer order = 0;

    /**
     * Enum representing the status of the attachment.
     */
    public enum Status {
        /**
         * The attachment is in created state.
         */
        CREATED,
        /**
         * The attachment is in draft state.
         */
        DRAFT,
        /**
         * The attachment has been uploaded.
         */
        UPLOADED,
        /**
         * The attachment is being processed.
         */
        PROCESSING,
        /**
         * The attachment is active and available.
         */
        ACTIVE,
        /**
         * The attachment is archived.
         */
        ARCHIVED,
        /**
         * The attachment is deleted.
         */
        DELETED,
        /**
         * There was an error with the attachment.
         */
        ERROR,
        /**
         * The attachment is locked.
         */
        LOCKED
    }

    @Override
    public int compareTo(Attachment o) {
        if (this == o) {
            return 0;
        }

        return Objects.compare(this.getOrder(), o.getOrder(), Integer::compareTo);
    }
}