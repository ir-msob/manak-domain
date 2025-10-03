package ir.msob.manak.domain.model.dms.document;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import ir.msob.manak.core.model.jima.childdomain.contactmedium.ContactMedium;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidation;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedAction;
import ir.msob.manak.core.model.jima.domain.Dto;
import ir.msob.manak.domain.model.dms.document.attachment.Attachment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.util.SortedSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentDto extends Document implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843863555451001L;

    public DocumentDto(String id, String name, String description, SortedSet<String> tags, SortedSet<Attachment> attachments, SortedSet<Characteristic> characteristics, SortedSet<ContactMedium> contactMediums, SortedSet<ObjectValidation> objectValidations, SortedSet<RelatedAction> relatedActions) {
        super(id, name, description, tags, attachments, characteristics, contactMediums, objectValidations, relatedActions);
    }
}