package ir.msob.manak.domain.model.party.individual;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.manak.domain.model.party.Party;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@Document(collection = Individual.DOMAIN_NAME)
@DomainInfo(domainName = Individual.DOMAIN_NAME_WITH_HYPHEN)
public class Individual extends Party {
    @Transient
    public static final String DOMAIN_NAME = "Individual";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "individual";
    @Serial
    private static final long serialVersionUID = -8938843863555452002L;

    public Individual(String id, String name, String description) {
        super(id, name, description);
    }

    public enum FN {
    }
}