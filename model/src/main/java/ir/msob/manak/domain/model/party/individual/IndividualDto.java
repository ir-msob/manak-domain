package ir.msob.manak.domain.model.party.individual;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.manak.core.model.jima.domain.Dto;
import ir.msob.manak.domain.model.common.ServiceName;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@DtoInfo(serviceName = ServiceName.PARTY, version = "v1")
public class IndividualDto extends Individual implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843863555451002L;

    @Builder
    public IndividualDto(String id, String name, String description) {
        super(id, name, description);
    }

}