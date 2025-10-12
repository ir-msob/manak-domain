package ir.msob.manak.domain.service.process.restful.service;

import ir.msob.jima.core.commons.security.BaseUserService;
import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.domain.model.process.process.Process;
import ir.msob.manak.domain.model.process.process.ProcessCriteria;
import ir.msob.manak.domain.model.process.process.ProcessDto;
import ir.msob.manak.domain.service.process.repository.BaseProcessRepository;
import ir.msob.manak.domain.service.process.service.BaseProcessService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseProcessRestResource<
        R extends BaseProcessRepository,
        S extends BaseProcessService<R>
        > implements ir.msob.jima.process.api.restful.service.rest.process.BaseProcessRestResource<User, Process, ProcessDto, ProcessCriteria, R, S> {

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