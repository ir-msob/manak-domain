package ir.msob.manak.domain.model.form.form;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.manak.core.model.jima.domain.Dto;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FormDto extends Form implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843864542632000L;

    @Builder
    public FormDto(String id, String name, String description) {
        super(id, name, description);
    }

}