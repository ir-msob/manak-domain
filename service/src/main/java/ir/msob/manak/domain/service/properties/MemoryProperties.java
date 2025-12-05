package ir.msob.manak.domain.service.properties;

import ir.msob.manak.domain.model.ai.embedding.EmbeddingOptions;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
public class MemoryProperties {

    private Embedding embedding = new Embedding();
    private Summary abstractiveSummary = new Summary();
    private Summary extractiveSummary = new Summary();
    private Chunk chunk = new Chunk();
    private Repository repository = new Repository();

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

    @Setter
    @Getter
    @NoArgsConstructor
    @ToString
    public static class Chunk {
        private Integer chunkSize;
        private Integer overlap;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @ToString
    public static class Repository {
        private Set<String> fileExtensions = Set.of(
                ".java", ".kt", ".xml", ".yml", ".yaml", ".properties", ".md", ".txt",
                ".py", ".js", ".ts", ".json", ".html", ".css", ".gradle", ".groovy",
                ".pom", ".sql", ".sh", ".bash", "dockerfile"
        );
        private Set<String> readMeFileName = Set.of(
                "README.md", "README.MD", "README", "readme.md", "readme"
        );
    }
}