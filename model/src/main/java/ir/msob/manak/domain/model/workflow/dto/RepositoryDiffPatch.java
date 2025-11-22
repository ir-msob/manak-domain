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
public class RepositoryDiffPatch implements Serializable {
    private String repositoryId;
    private String diff;
}
