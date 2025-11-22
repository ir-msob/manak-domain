package ir.msob.manak.domain.model.rms.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class MergeResult {
    private boolean success;
    private String pullRequestId;
    private String mergedCommitId;
    private String message;
    private MergeFailureReason failureReason;

    public enum MergeFailureReason {
        NONE,
        CONFLICT,
        PERMISSION_DENIED,
        VALIDATION_FAILED,
        PIPELINE_FAILED,
        UNKNOWN
    }
}
