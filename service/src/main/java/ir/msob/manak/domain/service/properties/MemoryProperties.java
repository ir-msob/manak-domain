package ir.msob.manak.domain.service.properties;

import ir.msob.manak.domain.model.ai.embedding.EmbeddingOptions;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
public class MemoryProperties {

    private Embedding embedding = new Embedding();

    @Setter
    @Getter
    @NoArgsConstructor
    @ToString
    public static class Embedding {
        private String model;
        private EmbeddingOptions options = new EmbeddingOptions();
    }
}