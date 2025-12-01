package ir.msob.manak.domain.model.dms.documentspecification;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.filter.Filter;
import ir.msob.manak.core.model.jima.domain.CriteriaAbstract;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class DocumentSpecificationCriteria extends CriteriaAbstract {
    @Serial
    private static final long serialVersionUID = -8938843863555450003L;
    private Filter<String> name;
    private Filter<String> key;
    private Filter<String> storageType;
}