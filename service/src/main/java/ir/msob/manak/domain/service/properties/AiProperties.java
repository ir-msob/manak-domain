package ir.msob.manak.domain.service.properties;

import ir.msob.manak.domain.model.ai.embedding.EmbeddingOptions;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
public class AiProperties {

    private Embedding embedding = new Embedding();
    private Summary abstractiveSummary = new Summary();
    private Summary extractiveSummary = new Summary();

    @Setter
    @Getter
    @NoArgsConstructor
    @ToString
    public static class Embedding {
        private String model;
        private EmbeddingOptions options = new EmbeddingOptions();
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @ToString
    public static class Summary {
        private String model;
        private String device;
        private Long maxLength = 150L;
        private Long minLength = 50L;
        private Long textSize = 10L;
    }
}