package ir.msob.manak.domain.model.dms.documentspecification;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedAction;
import ir.msob.manak.core.model.jima.domain.Dto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.util.Map;
import java.util.SortedSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DocumentSpecificationDto extends DocumentSpecification implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843863555451005L;

    public DocumentSpecificationDto(String id, String name, String description, SortedSet<Characteristic> characteristics, SortedSet<RelatedAction> relatedActions, StorageType storageType, String endpoint, String bucketOrContainer, String accessKey, String secretKey, String region, String basePath, Map<String, String> customProperties) {
        super(id, name, description, characteristics, relatedActions, storageType, endpoint, bucketOrContainer, accessKey, secretKey, region, basePath, customProperties);
    }
}