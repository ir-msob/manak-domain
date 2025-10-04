package ir.msob.manak.domain.test.shared;


import ir.msob.jima.core.test.CoreTestData;
import ir.msob.manak.domain.model.dms.document.attachment.Attachment;
import org.assertj.core.api.Assertions;

public class ManakDomainTestData {

    public static final String DEFAULT_PATH = "document/id/file1.txt";
    public static final String UPDATED_PATH = "document/id/file2.txt";

    public static final String DEFAULT_FILE_NAME = "file1.txt";
    public static final String UPDATED_FILE_NAME = "file2.txt";

    public static final Long DEFAULT_FILE_SIZE = 123456L;
    public static final Long UPDATED_FILE_SIZE = 654321L;

    // Attachment constants
    public static final Attachment DEFAULT_REQUIRED_ATTACHMENT = ManakDomainTestData.initDefaultRequiredAttachment();
    public static final Attachment DEFAULT_ATTACHMENT = ManakDomainTestData.initDefaultAttachment();
    public static final Attachment UPDATED_REQUIRED_ATTACHMENT = ManakDomainTestData.initUpdatedRequiredAttachment();
    public static final Attachment UPDATED_ATTACHMENT = ManakDomainTestData.initUpdatedAttachment();


    /**
     * Initializes the default required attachment.
     *
     * @return the initialized default required attachment
     */
    public static Attachment initDefaultRequiredAttachment() {
        return Attachment.builder()
                .filePath(DEFAULT_PATH)
                .fileName(DEFAULT_FILE_NAME)
                .fileSize(DEFAULT_FILE_SIZE)
                .mimeType(CoreTestData.DEFAULT_MIME_TYPE)
                .auditInfo(CoreTestData.DEFAULT_AUDIT_INFO)
                .build();
    }

    /**
     * Initializes the default  attachment.
     *
     * @return the initialized default  attachment
     */
    public static Attachment initDefaultAttachment() {
        return Attachment.builder()
                .filePath(DEFAULT_PATH)
                .fileName(DEFAULT_FILE_NAME)
                .fileSize(DEFAULT_FILE_SIZE)
                .mimeType(CoreTestData.DEFAULT_MIME_TYPE)
                .checksum(CoreTestData.DEFAULT_STRING)
                .auditInfo(CoreTestData.DEFAULT_AUDIT_INFO)
                .build();
    }

    /**
     * Initializes the updated required attachment.
     *
     * @return the initialized updated required attachment
     */
    public static Attachment initUpdatedRequiredAttachment() {
        return Attachment.builder()
                .filePath(UPDATED_PATH)
                .fileName(UPDATED_FILE_NAME)
                .fileSize(UPDATED_FILE_SIZE)
                .mimeType(CoreTestData.UPDATED_MIME_TYPE)
                .auditInfo(CoreTestData.UPDATED_AUDIT_INFO)
                .build();
    }

    /**
     * Initializes the updated  attachment.
     *
     * @return the initialized updated  attachment
     */
    public static Attachment initUpdatedAttachment() {
        return Attachment.builder()
                .status(Attachment.Status.ACTIVE)
                .filePath(UPDATED_PATH)
                .fileName(UPDATED_FILE_NAME)
                .fileSize(UPDATED_FILE_SIZE)
                .mimeType(CoreTestData.UPDATED_MIME_TYPE)
                .checksum(CoreTestData.UPDATED_STRING)
                .auditInfo(CoreTestData.UPDATED_AUDIT_INFO)
                .build();
    }

    public static void assertAttachment(Attachment before, Attachment after) {
        Assertions.assertThat(after.getFilePath()).isEqualTo(before.getFilePath());
        Assertions.assertThat(after.getFileName()).isEqualTo(before.getFileName());
        Assertions.assertThat(after.getMimeType()).isEqualTo(before.getMimeType());
        Assertions.assertThat(after.getFileSize()).isEqualTo(before.getFileSize());
        Assertions.assertThat(after.getChecksum()).isEqualTo(before.getChecksum());
        Assertions.assertThat(after.getStatus()).isEqualTo(before.getStatus());
        Assertions.assertThat(after.getOrder()).isEqualTo(before.getOrder());
    }
}
