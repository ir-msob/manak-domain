package ir.msob.manak.domain.model.memory;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Standard extends MemoryBase {
    private StandardCategory category;
    private String purpose;
    private List<String> sections = new ArrayList<>();
    private ComplianceLevel complianceLevel = ComplianceLevel.RECOMMENDED;
    private String versionReference; // e.g. "ISO 25010"
    private String complianceRules;  // what must be followed

    public enum ComplianceLevel {
        RECOMMENDED,
        REQUIRED
    }

    public enum StandardCategory {
        DOCUMENTATION
    }
}
