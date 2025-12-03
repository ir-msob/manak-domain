package ir.msob.manak.domain.model.memory.memory;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.ChildDomain;
import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import ir.msob.manak.core.model.jima.childdomain.characteristic.CharacteristicCriteria;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidation;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidationCriteria;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedAction;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedActionCriteria;
import ir.msob.manak.core.model.jima.childdomain.relatedobject.relateddomain.RelatedDomain;
import ir.msob.manak.core.model.jima.childdomain.relatedobject.relateddomain.RelatedDomainCriteria;
import ir.msob.manak.core.model.jima.domain.DomainAbstract;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Transient;

import java.io.Serial;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DomainInfo(domainName = Memory.DOMAIN_NAME_WITH_HYPHEN)
public class Memory extends DomainAbstract {
    @Transient
    public static final String DOMAIN_NAME = "Memory";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "memory";
    @Serial
    private static final long serialVersionUID = -8938843865549340000L;
    @NotNull
    private MemoryType type;
    @NotBlank
    private String title;
    private String description;
    private ValidityScope validityScope;
    private List<String> scopes = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
    private String version;
    private Integer priority; // 0-10
    private SourceType source;
    @Builder.Default
    private MemoryStatus status = MemoryStatus.DRAFT;
    private Instant validFrom;
    private Instant validTo;
    @Singular
    private List<String> examples = new ArrayList<>();
    @Singular
    private List<String> exceptions = new ArrayList<>();
    @Singular
    private List<String> useCases = new ArrayList<>();

    private BaseContent content;       // Polymorphic content

    @Singular
    @ChildDomain(cdClass = Characteristic.class, ccClass = CharacteristicCriteria.class)
    private SortedSet<Characteristic> characteristics = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = ObjectValidation.class, ccClass = ObjectValidationCriteria.class)
    private SortedSet<ObjectValidation> objectValidations = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = RelatedAction.class, ccClass = RelatedActionCriteria.class)
    private SortedSet<RelatedAction> relatedActions = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = RelatedDomain.class, ccClass = RelatedDomainCriteria.class)
    private SortedSet<RelatedDomain> relatedDomains = new TreeSet<>();

    public enum MemoryStatus {
        DRAFT, ACTIVE, DEPRECATED
    }

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

    public enum MemoryScope {
        GLOBAL,
        ORGANIZATION,
        TEAM,
        PROJECT,
        MODULE,
        COMPONENT,
        FILE,
        FUNCTION,
        TEMPORARY
    }

    public enum SourceType {
        DOCUMENT,
        REPOSITORY,
        CHAT,
        DB,
        LOG,
        MANUAL,
        TOOL,
        API,
        OBSERVATION,
        GENERATED
    }

    enum ImpactLevel {LOW, MEDIUM, HIGH}

    public enum FN {
        name, description
    }

    // ============================================================
    // SEALED ROOT CONTENT TYPE (strict, clean, enterprise-grade)
    // ============================================================
    public sealed interface BaseContent
            permits RuleContent, KnowledgeContent, HeuristicContent,
            PatternContent, StrategyContent, TemplateContent,
            StandardContent, MetricContent, DecisionModelContent {
    }

    // ============================================================
    // RULE
    // ============================================================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static final class RuleContent implements BaseContent {
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

    // ============================================================
    // KNOWLEDGE
    // ============================================================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static final class KnowledgeContent implements BaseContent {
        private KnowledgeCategory category;
        private String content;

        public enum KnowledgeCategory {
            BUSINESS,
            DOMAIN,
            TECHNICAL,
            ARCHITECTURE,
            PROCESS,
            CODEBASE
        }
    }

    // ============================================================
    // HEURISTIC
    // ============================================================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static final class HeuristicContent implements BaseContent {
        private String guideline;
        private String typicalUseCases;
    }

    // ============================================================
    // PATTERN
    // ============================================================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static final class PatternContent implements BaseContent {
        private PatternType patternType;
        private String problem;
        private String solution;
        private String consequences; // pros & cons

        public enum PatternType {
            DESIGN,
            ARCHITECTURAL,
            CODE,
            PROCESS
        }
    }

    // ============================================================
    // STRATEGY
    // ============================================================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static final class StrategyContent implements BaseContent {
        private String objective;
        private List<String> steps = new ArrayList<>();
        private List<String> prerequisites = new ArrayList<>();
    }

    // ============================================================
    // TEMPLATE
    // ============================================================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static final class TemplateContent implements BaseContent {
        private TemplateType templateType;
        private String template; // template content

        public enum TemplateType {
            CODE,
            DOCUMENT,
            PROMPT
        }
    }

    // ============================================================
    // STANDARD
    // ============================================================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static final class StandardContent implements BaseContent {
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

    // ============================================================
    // METRIC
    // ============================================================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static final class MetricContent implements BaseContent {
        private String formula;        // how to calculate
        private String unit;           // e.g. ms, %, score
        private String threshold;      // acceptable boundary
    }

    // ============================================================
    // DECISION MODEL
    // ============================================================
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static final class DecisionModelContent implements BaseContent {
        private String decisionLogic;  // DMN or internal logic
        private List<String> inputs;
        private List<String> outputs;
    }
}