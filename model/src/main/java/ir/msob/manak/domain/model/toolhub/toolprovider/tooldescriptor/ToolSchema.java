package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolSchema implements Serializable {
    @NotBlank
    private String type;
    private Map<String, ToolParameter> properties = new HashMap<>();
    private List<String> required = new ArrayList<>();
}
