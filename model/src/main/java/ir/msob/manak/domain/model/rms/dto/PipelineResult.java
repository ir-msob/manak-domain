package ir.msob.manak.domain.model.rms.dto;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PipelineResult {
    private String pipelineId;
    private PipelineStatus status;
    private String message;
    private Instant startedAt;
    private Instant finishedAt;
    private String url;

    public enum PipelineStatus {
        QUEUED,
        RUNNING,
        SUCCESS,
        FAILED,
        CANCELED
    }
}
