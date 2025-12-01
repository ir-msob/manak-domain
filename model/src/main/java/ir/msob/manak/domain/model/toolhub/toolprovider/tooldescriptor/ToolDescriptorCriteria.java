package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.filter.Filter;
import ir.msob.manak.core.model.jima.childdomain.criteria.ChildCriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class ToolDescriptorCriteria extends ChildCriteriaAbstract<ToolDescriptor> {

    private Filter<String> name;
    private Filter<String> description;
    private Filter<String> version;
    private Filter<ToolDescriptor.ToolDescriptorStatus> status;

}