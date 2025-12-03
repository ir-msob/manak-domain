package ir.msob.manak.domain.model.memory.model;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VectorDocument {
    @NotNull
    private String id;
    @NotNull
    private String text;
    @Singular("metaEntry")
    private Map<String, Object> metadata = new HashMap<>();
    @Nullable
    private Double score;

}
