package ir.msob.manak.domain.model.chat.embedding;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EmbeddingOptions {
    private String model;
    private Integer dimensions;
}