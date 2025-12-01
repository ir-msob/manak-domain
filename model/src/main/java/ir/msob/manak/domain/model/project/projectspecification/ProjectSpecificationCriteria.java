package ir.msob.manak.domain.model.project.projectspecification;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.filter.Filter;
import ir.msob.manak.core.model.jima.domain.CriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class ProjectSpecificationCriteria extends CriteriaAbstract {
    @Serial
    private static final long serialVersionUID = -8938843864243775000L;

    private Filter<String> name;
    private Filter<String> description;
}