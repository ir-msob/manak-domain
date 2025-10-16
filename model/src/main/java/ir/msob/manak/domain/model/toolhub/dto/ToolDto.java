package ir.msob.manak.domain.model.toolhub.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor.ToolSchema;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToolDto {
    private String name;
    private String description;
    private ToolSchema inputSchema;
    private ToolSchema outputSchema;
    private String version;
}
