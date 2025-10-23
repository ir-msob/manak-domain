package ir.msob.manak.domain.model.toolhub.model;

import ir.msob.manak.domain.model.toolhub.toolprovider.ToolProvider;
import ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor.ToolDescriptor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToolRegistry {
    private Map<String, ToolProvider> providers = new HashMap<>();

    public void registerProvider(ToolProvider provider) {
        providers.put(provider.getId(), provider);
    }

    public List<ToolDescriptor> getAllTools() {
        return providers.values().stream()
                .flatMap(p -> p.getTools().stream())
                .toList();
    }

    public Optional<ToolDescriptor> findToolById(String toolId) {
        return providers.values().stream()
                .flatMap(p -> p.getTools().stream())
                .filter(t -> t.getId().equals(toolId))
                .findFirst();
    }
}