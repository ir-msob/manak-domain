package ir.msob.manak.domain.model.memory.model;

import ir.msob.jima.core.commons.filter.Param;
import ir.msob.manak.domain.model.memory.memory.Memory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemoryQuery {
    @NotBlank
    private String query;
    @NotNull
    private Integer topK;
    private Double similarityThreshold;
    private Param<Memory.MemoryType> type;
    private Param<String> scopes;
    private Param<String> tags;
    private Param<Memory.ValidityScope> validityScope;
    private Param<Integer> priority;
    private Param<Memory.SourceType> sourceType;
    private Param<String> sourceName;
    private Param<String> sourceId;
    private Param<String> sourceReferringType;
    private Param<String> sourceRelatedId;

    public enum FN {
        sourceName,
        sourceId,
        sourceReferringType,
        sourceRelatedId
    }

}
