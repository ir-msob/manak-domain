package ir.msob.manak.domain.model.rms.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileContentDto implements Serializable {
    private String name;
    private String path;
    private String sha;
    private long size;
    private String url;
    private String content;
    private String encoding;
}
