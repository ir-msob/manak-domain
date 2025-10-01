package ir.msob.manak.domain.model.party;

import ir.msob.manak.core.model.jima.domain.Dto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PartyDto extends Party implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843863555451003L;

    @Builder
    public PartyDto(String id, String name, String description) {
        super(id, name, description);
    }

}