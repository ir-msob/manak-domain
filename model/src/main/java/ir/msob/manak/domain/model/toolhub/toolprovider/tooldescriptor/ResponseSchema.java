package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSchema implements Serializable {
    @NotBlank
    private ToolParameter toolId;
    @Singular
    private Map<String, ToolParameter> res;
    private ToolParameter error;

}
