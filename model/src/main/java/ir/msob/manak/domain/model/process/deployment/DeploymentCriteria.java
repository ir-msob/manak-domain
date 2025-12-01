package ir.msob.manak.domain.model.process.deployment;


import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.process.commons.criteria.BaseDeploymentCriteria;
import ir.msob.manak.core.model.jima.domain.Criteria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class DeploymentCriteria extends BaseDeploymentCriteria implements Criteria {
    @Serial
    private static final long serialVersionUID = 1;
}