package ir.msob.manak.domain.model.rms.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class FileContentBasic implements Serializable {
    private String name;
    private String path;
    private long size;
    private String content;
}
