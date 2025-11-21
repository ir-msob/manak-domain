package ir.msob.manak.domain.model.common.dto;

import ir.msob.jima.core.commons.shared.ModelType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvokeResponse extends ModelType {
    private String id;
    @NotBlank
    private String toolId;
    private Object result;
    private ErrorInfo error;
    @Singular
    private List<LogEntry> logs = List.of();
    @Singular("metaEntry")
    private Map<String, Object> metadata = new HashMap<>();
    private Instant executedAt;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ErrorInfo {
        private String code;
        private String message;
        private String stackTrace;
        @Singular
        private Map<String, Object> details = new HashMap<>();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class LogEntry {
        private Instant timestamp;
        private String level;
        private String message;
        @Singular("metaEntry")
        private Map<String, Object> context = new HashMap<>();
    }
}
