package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Map;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Example {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    private Map<String, Object> input;
    private Map<String, Object> output;
}
