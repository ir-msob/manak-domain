package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolSchema {
    @NotBlank
    private String type;
    private Map<String, ToolParameter> properties = new HashMap<>();
    private List<String> required = new ArrayList<>();
}
