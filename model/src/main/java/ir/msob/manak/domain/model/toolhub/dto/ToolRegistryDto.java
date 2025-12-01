package ir.msob.manak.domain.model.toolhub.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.jima.core.commons.shared.ModelType;
import ir.msob.manak.domain.model.common.ServiceName;
import ir.msob.manak.domain.model.common.model.ParameterDescriptor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@DtoInfo(serviceName = ServiceName.TOOL_HUB, version = "v1")
@DomainInfo(domainName = ToolRegistryDto.DOMAIN_NAME_WITH_HYPHEN)
public class ToolRegistryDto extends ModelType {
    @JsonIgnore
    public static final String DOMAIN_NAME_WITH_HYPHEN = "tool-registry";
    @NotBlank
    private String toolId;
    @NotBlank
    private String description;
    @Singular("inputParam")
    private Map<String, ParameterDescriptor> inputSchema = new HashMap<>();
    @NotNull
    private ParameterDescriptor outputSchema;
}
