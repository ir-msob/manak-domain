package ir.msob.manak.domain.model.toolhub.dto;

import ir.msob.jima.core.commons.shared.ModelType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvokeRequest extends ModelType {
    private String requestId;
    @NotBlank
    private String toolId;
    @Singular
    private Map<String, Object> parameters = new HashMap<>();
    @Singular("contextEntry")
    private Map<String, Object> context = new HashMap<>();
    @Singular("metaEntry")
    private Map<String, Object> metadata = new HashMap<>();
    private Instant timestamp;
}
