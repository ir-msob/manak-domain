package ir.msob.manak.domain.model.toolhub.toolprovider;

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
public class ToolProviderCriteria extends CriteriaAbstract {
    @Serial
    private static final long serialVersionUID = -8938843863599063000L;

    private Filter<String> name;
    private Filter<String> description;
}