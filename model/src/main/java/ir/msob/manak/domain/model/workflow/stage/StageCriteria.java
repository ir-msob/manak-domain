package ir.msob.manak.domain.model.workflow.stage;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StageCriteria extends CriteriaAbstract {
    @Serial
    private static final long serialVersionUID = -8938843865642270000L;

    private Filter<String> name;
    private Filter<String> description;
}