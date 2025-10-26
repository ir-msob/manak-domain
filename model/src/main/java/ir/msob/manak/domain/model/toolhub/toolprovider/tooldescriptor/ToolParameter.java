package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolParameter implements Serializable{
    @NotBlank
    private String type;          // string, number, boolean, object, array
    @NotBlank
    private String description;
    private Serializable defaultValue;
    private Serializable example;
    private boolean required;

}