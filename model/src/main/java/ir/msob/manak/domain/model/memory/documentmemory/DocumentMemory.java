package ir.msob.manak.domain.model.memory.documentmemory;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentMemory {
    private String documentId;
    private String filePath;
    private String fileName;
    private String mimeType;
    @Singular("metaEntry")
    private Map<String, Object> metadata = new HashMap<>();
}