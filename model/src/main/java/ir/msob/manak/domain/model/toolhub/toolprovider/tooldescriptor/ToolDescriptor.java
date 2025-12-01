package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.shared.auditinfo.AuditInfo;
import ir.msob.manak.core.model.jima.childdomain.ChildDomainAbstract;
import ir.msob.manak.domain.model.common.model.ErrorDescriptor;
import ir.msob.manak.domain.model.common.model.ParameterDescriptor;
import ir.msob.manak.domain.model.common.model.RetryPolicy;
import ir.msob.manak.domain.model.common.model.TimeoutPolicy;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class ToolDescriptor extends ChildDomainAbstract implements Comparable<ToolDescriptor> {
    @NotBlank
    private String name;
    private String displayName;
    private String category;
    @NotNull
    private String version;
    @Singular
    private Set<String> tags = new HashSet<>();
    @NotBlank
    private String description;
    @Singular
    private Map<String, ParameterDescriptor> parameters = new HashMap<>();
    private ResponseDescriptor response;
    @Singular
    private List<Example> examples;
    @Singular
    private List<ErrorDescriptor> errors;
    private RetryPolicy retryPolicy;
    private TimeoutPolicy timeoutPolicy;
    @NotNull
    @Builder.Default
    private ToolDescriptorStatus status = ToolDescriptorStatus.ACTIVE;

    /**
     * Audit information for the attachment (created/updated info).
     */
    @Builder.Default
    private AuditInfo auditInfo = AuditInfo.builder().build();

    public String getToolId() {
        return String.format("%s:%s:%s", getCategory(), getName(), getVersion());
    }

    @Override
    public int compareTo(ToolDescriptor o) {
        if (this == o) {
            return 0;
        }

        return Objects.compare(this.getName(), o.getName(), String::compareTo);
    }

    public enum ToolDescriptorStatus {
        ACTIVE, DEPRECATED, REMOVED, DRAFT
    }

}