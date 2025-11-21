package ir.msob.manak.domain.model.vectorhub.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentOverview implements Serializable {
    private String id;
    private String overview;
    private Map<String, Object> metadata = new HashMap<>();
}
