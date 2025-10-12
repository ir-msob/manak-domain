package ir.msob.manak.domain.model.process.deployment;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.process.commons.dto.BaseDeploymentDto;
import ir.msob.manak.core.model.jima.domain.Dto;
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
public class DeploymentDto extends BaseDeploymentDto implements Dto {
    @Serial
    private static final long serialVersionUID = 1;
}