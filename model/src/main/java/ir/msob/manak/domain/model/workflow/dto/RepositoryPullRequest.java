package ir.msob.manak.domain.model.workflow.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RepositoryPullRequest {
    private String repositoryId;
    private String fromBranchName;
    private String targetBranchName;
    private String pullRequestLink;
}
