package ir.msob.manak.domain.model.chat.embedding;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Embedding {
    private float[] embedding;
    private Integer index;
}
