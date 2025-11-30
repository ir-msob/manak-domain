package ir.msob.manak.domain.model.chat.embedding;

import ir.msob.jima.core.commons.shared.ModelType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EmbeddingResponseDto extends ModelType {
    private String requestId;
    private String model;
    @Singular
    private List<Embedding> embeddings = new ArrayList<>();
}
