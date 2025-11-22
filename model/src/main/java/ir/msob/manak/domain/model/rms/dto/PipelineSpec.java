package ir.msob.manak.domain.model.rms.dto;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PipelineSpec {
    private String triggerSource;       // e.g. "manual", "commit", "schedule", "pr"
    private Map<String, String> variables = new HashMap<>();
    private String branch;
    private String commitId;
}
