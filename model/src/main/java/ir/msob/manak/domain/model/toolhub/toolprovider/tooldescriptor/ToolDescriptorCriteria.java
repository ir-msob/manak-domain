package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.filter.Filter;
import ir.msob.jima.core.commons.shared.auditinfo.AuditInfoFilters;
import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToolDescriptorCriteria extends ir.msob.jima.core.commons.childdomain.characteristic.CharacteristicCriteria<String, Characteristic> {

    private Filter<String> name;
    private Filter<String> description;
    private Filter<String> version;
    private Filter<ToolDescriptor.ToolDescriptorStatus> status;

}