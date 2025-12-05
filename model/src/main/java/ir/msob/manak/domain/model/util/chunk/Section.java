package ir.msob.manak.domain.model.util.chunk;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Section {
    private String text;
    private Integer startLine; // 1-based
}
