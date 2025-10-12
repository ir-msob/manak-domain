package ir.msob.manak.domain.service.process.restful.service;

import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.domain.model.process.task.Task;
import ir.msob.manak.domain.model.process.task.TaskCriteria;
import ir.msob.manak.domain.model.process.task.TaskDto;
import ir.msob.manak.domain.service.process.repository.BaseTaskRepository;
import ir.msob.manak.domain.service.process.service.BaseTaskService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseTaskRestResource<
        R extends BaseTaskRepository,
        S extends BaseTaskService<R>
        > implements ir.msob.jima.process.api.restful.service.rest.task.BaseTaskRestResource<User, Task, TaskDto, TaskCriteria, R, S> {

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