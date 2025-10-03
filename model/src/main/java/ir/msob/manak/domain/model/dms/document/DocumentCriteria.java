package ir.msob.manak.domain.model.dms.document;

import ir.msob.manak.core.model.jima.domain.CriteriaAbstract;
import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.filter.Filter;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import ir.msob.jima.core.commons.shared.auditinfo.AuditInfoFilters;
import ir.msob.manak.domain.model.dms.document.attachment.AttachmentCriteria;
import ir.msob.manak.core.model.jima.childdomain.characteristic.CharacteristicCriteria;
import ir.msob.manak.core.model.jima.childdomain.contactmedium.ContactMediumCriteria;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidationCriteria;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedActionCriteria;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentCriteria extends CriteriaAbstract {
    @Serial
    private static final long serialVersionUID = -8938843863555450006L;

    private Filter<String> name;
    private Filter<String> description;
    private Filter<String> tags;
    private AttachmentCriteria attachments;
    private CharacteristicCriteria characteristics;
    private ContactMediumCriteria contactMediums;
    private ObjectValidationCriteria objectValidations;
    private RelatedActionCriteria relatedActions;
    private AuditInfoFilters auditInfo;
}