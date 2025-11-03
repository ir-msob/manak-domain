package ir.msob.manak.domain.model.toolhub.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.shared.ModelType;
import ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor.ToolParameter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToolDto extends ModelType {
    @NotBlank
    private String toolId;
    @NotBlank
    private String description;
    @Singular("inputParam")
    private Map<String, ToolParameter> inputSchema = new HashMap<>();
    @NotNull
    private ToolParameter outputSchema;
    @NotNull
    private ToolParameter errorSchema;
    @NotNull
    private String version;
}
