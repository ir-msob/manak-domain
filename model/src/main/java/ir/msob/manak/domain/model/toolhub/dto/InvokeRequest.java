package ir.msob.manak.domain.model.toolhub.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvokeRequest {
    private String toolId;
    private Map<String, Object> params = new HashMap<>();
}
