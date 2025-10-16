package ir.msob.manak.domain.process.restful.service;

import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.domain.model.process.deployment.Deployment;
import ir.msob.manak.domain.model.process.deployment.DeploymentCriteria;
import ir.msob.manak.domain.model.process.deployment.DeploymentDto;
import ir.msob.manak.domain.process.repository.BaseDeploymentRepository;
import ir.msob.manak.domain.process.service.BaseDeploymentService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDeploymentRestResource<
        R extends BaseDeploymentRepository,
        S extends BaseDeploymentService<R>
        > implements ir.msob.jima.process.api.restful.service.rest.deployment.BaseDeploymentRestResource<User, Deployment, DeploymentDto, DeploymentCriteria, R, S> {

    @Autowired
    S service;

    @Autowired
    BaseUserService baseUserService;

    @Override
    public S getService() {
        return service;
    }

    @Override
    public BaseUserService getUserService() {
        return baseUserService;
    }
}