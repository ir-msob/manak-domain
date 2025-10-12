package ir.msob.manak.domain.service.process.service;

import ir.msob.jima.process.ral.activiti.beans.repository.BaseActivitiProcessRepository;
import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.domain.model.process.process.Process;
import ir.msob.manak.domain.model.process.process.ProcessCriteria;
import ir.msob.manak.domain.model.process.process.ProcessDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseProcessService<R extends BaseActivitiProcessRepository<Process, ProcessCriteria>> implements ir.msob.jima.process.commons.service.BaseProcessService<User, Process, ProcessDto, ProcessCriteria, R> {

    @Autowired
    R repository;

    @Override
    public R getRepository() {
        return repository;
    }

}
