package ir.msob.manak.domain.model.rms.repository.branch;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.shared.auditinfo.AuditInfo;
import ir.msob.manak.core.model.jima.childdomain.ChildDomainAbstract;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Objects;

/**
 * Represents a branch entity in the RMS system.
 * Contains metadata such as name, description, status, and audit information.
 */
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Branch extends ChildDomainAbstract implements Comparable<Branch> {

    /**
     * The name of the branch. Must be unique and non-blank.
     */
    @NotBlank
    private String name;

    /**
     * A short description of the branch.
     */
    @NotBlank
    private String description;

    /**
     * The current status of the branch.
     */
    @NotNull
    @Builder.Default
    private Status status = Status.ACTIVE;

    /**
     * Audit information for the branch (created/updated info).
     */
    @Builder.Default
    private AuditInfo auditInfo = AuditInfo.builder().build();

    // ---------------------------------------------------------------------------------------------
    // Comparable
    // ---------------------------------------------------------------------------------------------
    @Override
    public int compareTo(Branch other) {
        if (other == null) return 1;
        if (this.name == null && other.name == null) return 0;
        if (this.name == null) return -1;
        if (other.name == null) return 1;
        return this.name.compareTo(other.name);
    }

    // ---------------------------------------------------------------------------------------------
    // Equals and HashCode consistent with compareTo
    // ---------------------------------------------------------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Branch)) return false;
        Branch branch = (Branch) o;
        return Objects.equals(name, branch.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /**
     * Status of the branch.
     */
    public enum Status {
        /**
         * The branch is active and available.
         */
        ACTIVE,

        /**
         * The branch is deactivated and not available for use.
         */
        DEACTIVATED
    }
}
