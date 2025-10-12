package ir.msob.manak.domain.model.form.formspecification;

import ir.msob.manak.core.model.jima.domain.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormSpecificationDto extends FormSpecification implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843864655670000L;

    @Builder
    public FormSpecificationDto(String id, String name, String description) {
        super(id, name, description);
    }

}