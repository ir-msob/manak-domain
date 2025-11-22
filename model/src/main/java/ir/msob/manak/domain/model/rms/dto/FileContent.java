package ir.msob.manak.domain.model.rms.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
public class FileContent extends FileContentBasic {
    private String sha;
    private String url;
    private String encoding;
}
