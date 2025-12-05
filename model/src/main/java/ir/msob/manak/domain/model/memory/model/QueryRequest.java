package ir.msob.manak.domain.model.memory.model;

import ir.msob.jima.core.commons.filter.Param;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryRequest {
    @NotBlank
    private String query;
    @NotNull
    private Integer topK;
    private Double similarityThreshold;
    private Map<String, Param<?>> metadata = new HashMap<>();
}
