package ir.msob.manak.domain.service.process.service;

import ir.msob.jima.core.commons.file.BaseFileClient;
import ir.msob.jima.process.ral.activiti.beans.repository.BaseActivitiDeploymentRepository;
import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.domain.model.process.deployment.Deployment;
import ir.msob.manak.domain.model.process.deployment.DeploymentCriteria;
import ir.msob.manak.domain.model.process.deployment.DeploymentDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDeploymentService<R extends BaseActivitiDeploymentRepository<Deployment, DeploymentCriteria>> implements ir.msob.jima.process.commons.service.BaseDeploymentService<User, Deployment, DeploymentDto, DeploymentCriteria, R> {

    @Autowired
    BaseFileClient baseFileClient;

    @Autowired
    R repository;

    @Override
    public BaseFileClient getFileClient() {
        return baseFileClient;
    }

    @Override
    public R getRepository() {
        return repository;
    }
}
