package ir.msob.manak.domain.model.memory;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Rule extends MemoryBase {

    private RuleCategory category;
    private String condition;             // If condition (optional)
    private String action;                // What must be done
    private Severity severity;            // LOW, MEDIUM, HIGH
    private List<String> relatedExamples; // Example code or usage

    public enum Severity {
        LOW, MEDIUM, HIGH, CRITICAL
    }
    public enum RuleCategory {
        DESIGN, CODING, LOGGING, TESTING, ARCHITECTURE, DEPLOYMENT
    }
}