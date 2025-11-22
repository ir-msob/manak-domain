package ir.msob.manak.domain.model.rms.dto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PullRequestInfo {
    private String id;
    private String title;
    private String description;
    private String sourceBranch;
    private String targetBranch;
    private PullRequestStatus status;
    private String author;
    private String url;
    private Instant createdAt;
    private Instant updatedAt;

    public enum PullRequestStatus {
        OPEN,
        MERGED,
        CLOSED,
        DRAFT
    }
}
