package ir.msob.manak.domain.process.repository;


import ir.msob.jima.core.commons.repository.BaseQueryBuilder;
import ir.msob.jima.process.ral.camunda.beans.query.CamundaApiClient;
import ir.msob.jima.process.ral.camunda.beans.repository.BaseCamundaTaskRepository;
import ir.msob.manak.domain.model.process.task.Task;
import ir.msob.manak.domain.model.process.task.TaskCriteria;

public abstract class BaseTaskRepository extends BaseCamundaTaskRepository<Task, TaskCriteria> {


    public BaseTaskRepository(CamundaApiClient camundaClient, BaseQueryBuilder queryBuilder) {
        super(camundaClient, queryBuilder);
    }
}
