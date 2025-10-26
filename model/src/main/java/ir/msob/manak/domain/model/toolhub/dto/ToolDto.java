package ir.msob.manak.domain.model.toolhub.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.shared.ModelType;
import ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor.RequestSchema;
import ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor.ResponseSchema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToolDto extends ModelType {
    @NotBlank
    private String name;
    @NotBlank
    private String key;
    @NotBlank
    private String description;
    @NotNull
    private RequestSchema inputSchema;
    @NotNull
    private ResponseSchema outputSchema;
    @NotNull
    private String version;
}
