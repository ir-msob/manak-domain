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
    private String repoUrl;
    private String branch;
    private String filePath;
    private String content;
}
