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
public class ResourceOverview implements Serializable {
    private String id;
    private Type type;
    private String overview;

    public enum Type {
        DOCUMENT, REPOSITORY
    }
}
