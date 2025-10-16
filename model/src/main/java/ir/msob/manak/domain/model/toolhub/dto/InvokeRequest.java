package ir.msob.manak.domain.model.toolhub.dto;

import ir.msob.jima.core.commons.shared.ModelType;
import lombok.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvokeRequest extends ModelType {
    private String toolId;

    @Builder.Default
    private Map<String, Serializable> params = new HashMap<>();
}
