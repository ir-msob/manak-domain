package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolParameter {
    @NotBlank
    private String type;          // string, number, boolean, object, array
    @NotBlank
    private String description;
    private Object defaultValue;
    private Object example;
    private boolean required;

}