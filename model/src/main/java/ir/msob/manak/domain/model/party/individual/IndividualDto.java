package ir.msob.manak.domain.model.party.individual;

import ir.msob.manak.core.model.jima.domain.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndividualDto extends Individual implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843863555451002L;

    @Builder
    public IndividualDto(String id, String name, String description) {
        super(id, name, description);
    }

}