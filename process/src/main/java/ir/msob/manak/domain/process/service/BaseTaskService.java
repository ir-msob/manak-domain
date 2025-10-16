package ir.msob.manak.domain.process.service;

import ir.msob.jima.process.ral.activiti.beans.repository.BaseActivitiTaskRepository;
import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.domain.model.process.task.Task;
import ir.msob.manak.domain.model.process.task.TaskCriteria;
import ir.msob.manak.domain.model.process.task.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseTaskService<R extends BaseActivitiTaskRepository<Task, TaskCriteria>> implements ir.msob.jima.process.commons.service.BaseTaskService<User, Task, TaskDto, TaskCriteria, R> {

    @Autowired
    R repository;

    @Override
    public R getRepository() {
        return repository;
    }
}