package ir.msob.manak.domain.model.util.chunk;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StringHolder {
    private String text;
    private int relativeStartLine; // 0-based within section
    private int relativeEndLine;   // 0-based within section
}
