package ir.msob.manak.domain.model.chat.modelspecification;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.manak.core.model.jima.domain.Dto;
import ir.msob.manak.domain.model.common.ServiceName;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@DtoInfo(serviceName = ServiceName.AI, version = "v1")
public class ModelSpecificationDto extends ModelSpecification implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843863590882000L;

    @Builder
    public ModelSpecificationDto(String id, String name, String description) {
        super(id, name, description);
    }

}