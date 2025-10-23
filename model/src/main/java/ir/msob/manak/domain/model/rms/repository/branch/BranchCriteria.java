package ir.msob.manak.domain.model.rms.repository.branch;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.filter.Filter;
import ir.msob.jima.core.commons.shared.auditinfo.AuditInfoFilters;
import ir.msob.manak.core.model.jima.childdomain.criteria.ChildCriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BranchCriteria extends ChildCriteriaAbstract<Branch> {
    private Filter<String> name;
    private Filter<Branch.Status> status;
    private Filter<Boolean> defaultBranch;
    private AuditInfoFilters auditInfo;
}