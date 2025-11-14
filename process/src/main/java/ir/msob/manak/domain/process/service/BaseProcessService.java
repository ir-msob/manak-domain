package ir.msob.manak.domain.process.service;

import ir.msob.jima.process.ral.camunda.beans.repository.BaseCamundaProcessRepository;
import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.domain.model.process.process.Process;
import ir.msob.manak.domain.model.process.process.ProcessCriteria;
import ir.msob.manak.domain.model.process.process.ProcessDto;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseProcessService<R extends BaseCamundaProcessRepository<Process, ProcessCriteria>> implements ir.msob.jima.process.commons.service.BaseProcessService<User, Process, ProcessDto, ProcessCriteria, R> {

    @Autowired
    R repository;

    @Override
    public R getRepository() {
        return repository;
    }

}
