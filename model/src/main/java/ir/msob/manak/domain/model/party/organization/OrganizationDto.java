package ir.msob.manak.domain.model.party.organization;

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
@JsonInclude(JsonInclude.Include.NON_NULL)
@DtoInfo(serviceName = ServiceName.PARTY, version = "v1")
public class OrganizationDto extends Organization implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843863555451004L;

    @Builder
    public OrganizationDto(String id, String name, String description) {
        super(id, name, description);
    }

}