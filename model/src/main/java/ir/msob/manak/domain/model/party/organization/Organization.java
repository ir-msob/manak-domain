package ir.msob.manak.domain.model.party.organization;

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
@Document(collection = Organization.DOMAIN_NAME)
@DomainInfo(domainName = Organization.DOMAIN_NAME_WITH_HYPHEN)
public class Organization extends Party {
    @Transient
    public static final String DOMAIN_NAME = "Organization";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "organization";
    @Serial
    private static final long serialVersionUID = -8938843863555452003L;


    public Organization(String id, String name, String description) {
        super(id, name, description);

    }

    public enum FN {
    }
}