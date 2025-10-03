package ir.msob.manak.domain.model.party.organization;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.manak.core.model.jima.domain.Dto;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrganizationDto extends Organization implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843863555451004L;

    @Builder
    public OrganizationDto(String id, String name, String description) {
        super(id, name, description);
    }

}