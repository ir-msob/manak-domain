package ir.msob.manak.domain.model.rms.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FileContent {
    private String path;
    private String content;
}
