package ir.msob.manak.domain.process.repository;

import ir.msob.jima.core.commons.repository.BaseQueryBuilder;
import ir.msob.jima.process.ral.camunda.beans.query.CamundaApiClient;
import ir.msob.jima.process.ral.camunda.beans.repository.BaseCamundaDeploymentRepository;
import ir.msob.manak.domain.model.process.deployment.Deployment;
import ir.msob.manak.domain.model.process.deployment.DeploymentCriteria;

public abstract class BaseDeploymentRepository extends BaseCamundaDeploymentRepository<Deployment, DeploymentCriteria> {


    protected BaseDeploymentRepository(CamundaApiClient camundaClient, BaseQueryBuilder queryBuilder) {
        super(camundaClient, queryBuilder);
    }
}
