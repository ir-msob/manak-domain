package ir.msob.manak.domain.model.toolhub.toolprovider;

import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidation;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedAction;
import ir.msob.manak.core.model.jima.domain.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor.ToolDescriptor;
import lombok.*;

import java.io.Serial;
import java.util.SortedSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToolProviderDto extends ToolProvider implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843863766936000L;

    @Builder
    public ToolProviderDto(String name, String description, String baseUrl, String endpoint, SortedSet<ToolDescriptor> tools, SortedSet<Characteristic> characteristics, SortedSet<ObjectValidation> objectValidations, SortedSet<RelatedAction> relatedActions) {
        super(name, description, baseUrl, endpoint, tools, characteristics, objectValidations, relatedActions);
    }
}