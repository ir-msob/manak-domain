package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.BaseChildDomainAbstract;
import ir.msob.jima.core.commons.shared.auditinfo.AuditInfo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToolDescriptor extends BaseChildDomainAbstract<String> implements Comparable<ToolDescriptor> {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private ToolSchema inputSchema;
    @NotNull
    private ToolSchema outputSchema;
    @NotNull
    private String version;
    @NotNull
    @Builder.Default
    private ToolDescriptorStatus status = ToolDescriptorStatus.ACTIVE;

    /**
     * Audit information for the attachment (created/updated info).
     */
    @Builder.Default
    private AuditInfo auditInfo = AuditInfo.builder().build();


    @Override
    public int compareTo(ToolDescriptor o) {
        if (this == o) {
            return 0;
        }

        return Objects.compare(this.getName(), o.getName(), String::compareTo);
    }

    public enum ToolDescriptorStatus {
        ACTIVE,
        INACTIVE,
        DEPRECATED
    }
}