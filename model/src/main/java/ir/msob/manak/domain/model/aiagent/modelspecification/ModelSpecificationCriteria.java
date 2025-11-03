package ir.msob.manak.domain.model.aiagent.modelspecification;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.filter.Filter;
import ir.msob.manak.core.model.jima.domain.CriteriaAbstract;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ModelSpecificationCriteria extends CriteriaAbstract {
    @Serial
    private static final long serialVersionUID = -8938843864023345000L;

    private Filter<String> name;
    private Filter<String> key;
    private Filter<String> modelName;
    private Filter<String> type;
}