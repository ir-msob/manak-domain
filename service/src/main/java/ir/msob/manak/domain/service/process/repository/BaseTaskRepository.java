package ir.msob.manak.domain.service.process.repository;

import ir.msob.jima.process.ral.activiti.beans.query.TaskQueryBuilder;
import ir.msob.jima.process.ral.activiti.beans.repository.BaseActivitiTaskRepository;
import ir.msob.manak.domain.model.process.task.Task;
import ir.msob.manak.domain.model.process.task.TaskCriteria;
import org.activiti.engine.TaskService;

public abstract class BaseTaskRepository extends BaseActivitiTaskRepository<Task, TaskCriteria> {

    public BaseTaskRepository(TaskService taskService, TaskQueryBuilder queryBuilder) {
        super(taskService, queryBuilder);
    }
}
