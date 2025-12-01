package ir.msob.manak.domain.model.process.task;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.jima.process.commons.dto.BaseTaskDto;
import ir.msob.manak.core.model.jima.domain.Dto;
import ir.msob.manak.domain.model.common.ServiceName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@DtoInfo(serviceName = ServiceName.PROCESS, version = "v1")
public class TaskDto extends BaseTaskDto implements Dto {
    @Serial
    private static final long serialVersionUID = 1;


}