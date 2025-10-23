package ir.msob.manak.domain.model.dms.documentspecification;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedAction;
import ir.msob.manak.core.model.jima.domain.Dto;
import lombok.*;

import java.io.Serial;
import java.util.SortedSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentSpecificationDto extends DocumentSpecification implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843863555451005L;

    @Builder
    public DocumentSpecificationDto(String name, String description, String key, String storageType, SortedSet<Characteristic> characteristics, SortedSet<RelatedAction> relatedActions) {
        super(name, description, key, storageType, characteristics, relatedActions);
    }
}