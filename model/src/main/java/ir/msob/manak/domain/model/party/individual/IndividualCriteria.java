package ir.msob.manak.domain.model.party.individual;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.manak.domain.model.party.PartyCriteria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IndividualCriteria extends PartyCriteria {
    @Serial
    private static final long serialVersionUID = -8938843863555450002L;

}