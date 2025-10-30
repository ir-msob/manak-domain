package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseSchema implements Serializable {
    @NotBlank
    private ToolParameter toolId;
    private ToolParameter res;
    private ToolParameter error;

}
