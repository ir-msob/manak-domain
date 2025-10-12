package ir.msob.manak.domain.service.process.repository;

import ir.msob.jima.process.ral.activiti.beans.query.ProcessInstanceQueryBuilder;
import ir.msob.jima.process.ral.activiti.beans.repository.BaseActivitiProcessRepository;
import ir.msob.manak.domain.model.process.process.Process;
import ir.msob.manak.domain.model.process.process.ProcessCriteria;
import org.activiti.engine.RuntimeService;

public abstract class BaseProcessRepository extends BaseActivitiProcessRepository<Process, ProcessCriteria> {

    public BaseProcessRepository(RuntimeService runtimeService, ProcessInstanceQueryBuilder queryBuilder) {
        super(runtimeService, queryBuilder);
    }
}
