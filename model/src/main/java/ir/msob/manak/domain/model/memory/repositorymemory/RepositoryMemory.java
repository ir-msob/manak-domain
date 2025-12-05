package ir.msob.manak.domain.model.memory.repositorymemory;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RepositoryMemory {
    private String repositoryId;
    private String branch;
    @Singular("metaEntry")
    private Map<String, Object> metadata = new HashMap<>();
}