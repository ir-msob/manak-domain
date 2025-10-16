package ir.msob.manak.domain.process.repository;

import ir.msob.jima.process.ral.activiti.beans.query.DeploymentQueryBuilder;
import ir.msob.jima.process.ral.activiti.beans.repository.BaseActivitiDeploymentRepository;
import ir.msob.manak.domain.model.process.deployment.Deployment;
import ir.msob.manak.domain.model.process.deployment.DeploymentCriteria;
import org.activiti.engine.RepositoryService;

public abstract class BaseDeploymentRepository extends BaseActivitiDeploymentRepository<Deployment, DeploymentCriteria> {

    public BaseDeploymentRepository(RepositoryService repositoryService, DeploymentQueryBuilder queryBuilder) {
        super(repositoryService, queryBuilder);
    }
}
