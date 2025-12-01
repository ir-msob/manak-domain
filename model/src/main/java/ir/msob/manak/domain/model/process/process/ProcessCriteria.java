package ir.msob.manak.domain.model.process.process;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.process.commons.criteria.BaseProcessCriteria;
import ir.msob.manak.core.model.jima.domain.Criteria;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class ProcessCriteria extends BaseProcessCriteria implements Criteria {
    @Serial
    private static final long serialVersionUID = 1;

}