package ir.msob.manak.domain.model.util.chunk;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChunkFile {
    private String text;
    private Long index;
    private Integer startLine; // nullable for non-line-based types
    private Integer endLine;   // nullable for non-line-based types
}
