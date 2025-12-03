package ir.msob.manak.domain.model.memory.memory;

import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.manak.core.model.jima.domain.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@DtoInfo(serviceName = Memory.DOMAIN_NAME_WITH_HYPHEN, version = "v1")
public class MemoryDto extends Memory implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843864119861000L;

}