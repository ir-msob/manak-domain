package ir.msob.manak.domain.process.repository;


import ir.msob.jima.core.commons.repository.BaseQueryBuilder;
import ir.msob.jima.process.ral.camunda.beans.query.CamundaApiClient;
import ir.msob.jima.process.ral.camunda.beans.repository.BaseCamundaProcessRepository;
import ir.msob.manak.domain.model.process.process.Process;
import ir.msob.manak.domain.model.process.process.ProcessCriteria;

public abstract class BaseProcessRepository extends BaseCamundaProcessRepository<Process, ProcessCriteria> {

    public BaseProcessRepository(CamundaApiClient camundaClient, BaseQueryBuilder queryBuilder) {
        super(camundaClient, queryBuilder);
    }
}
