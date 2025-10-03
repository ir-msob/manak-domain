package ir.msob.manak.domain.model.dms.document.attachment;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.filter.Filter;
import ir.msob.jima.core.commons.shared.auditinfo.AuditInfoFilters;
import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttachmentCriteria extends ir.msob.jima.core.commons.childdomain.characteristic.CharacteristicCriteria<String, Characteristic> {

    private Filter<String> filePath;
    private Filter<Attachment.Status> status;
    private Filter<String> fileName;
    private Filter<String> mimeType;
    private Filter<Long> fileSize;
    private Filter<String> checksum;
    private AuditInfoFilters auditInfo;
}