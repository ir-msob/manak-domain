package ir.msob.manak.domain.model.form.formspecification;

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
@DtoInfo(serviceName = ServiceName.FORM, version = "v1")
public class FormSpecificationDto extends FormSpecification implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843864655670000L;

    @Builder
    public FormSpecificationDto(String id, String name, String description) {
        super(id, name, description);
    }

}