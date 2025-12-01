package ir.msob.manak.domain.model.memory;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public abstract class MemoryBase {
    private String id;
    private MemoryType type;
    private String title;
    private String description;
    private ValidityScope validityScope;
    private List<String> scopes = new ArrayList<>();
    private String projectId; // when PROJECT-scoped
    private List<String> tags = new ArrayList<>();
    private String version;
    private Integer priority; // 0-10
    private SourceType source;
    private MemoryStatus status = MemoryStatus.DRAFT;
    private Instant validFrom;
    private Instant validTo;
    private List<String> examples = new ArrayList<>();
    private List<String> exceptions = new ArrayList<>();
    private List<String> whenToUse = new ArrayList<>();


    private Map<String, Object> metadata = new HashMap<>();

    public enum MemoryType {
        RULE, KNOWLEDGE, HEURISTIC, PATTERN, STRATEGY,
        TEMPLATE, STANDARD, METRIC, DECISION_MODEL
    }

    public enum ValidityScope {
        GLOBAL,
        ORGANIZATION,
        PROJECT,
        TEMPORARY
    }

    public enum SourceType {
        DOCUMENT,
        REPOSITORY,
        CHAT,
        DB,
        LOG,
        MANUAL
    }

    public enum MemoryStatus {
        DRAFT, ACTIVE, DEPRECATED
    }
}