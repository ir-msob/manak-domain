package ir.msob.manak.domain.model.workflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResourceContent implements Serializable {
    private String id;
    private String resourceId;
    private Type type;
    private String path;
    private String content;
    private String optimizedContent;

    public enum Type {
        DOCUMENT, REPOSITORY
    }
}
