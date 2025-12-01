package ir.msob.manak.domain.model.rms.repository;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.jima.core.commons.childdomain.ChildDomain;
import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.manak.core.model.jima.childdomain.characteristic.Characteristic;
import ir.msob.manak.core.model.jima.childdomain.characteristic.CharacteristicCriteria;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidation;
import ir.msob.manak.core.model.jima.childdomain.objectvalidation.ObjectValidationCriteria;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedAction;
import ir.msob.manak.core.model.jima.childdomain.relatedaction.RelatedActionCriteria;
import ir.msob.manak.core.model.jima.domain.DomainAbstract;
import ir.msob.manak.domain.model.rms.repository.branch.Branch;
import ir.msob.manak.domain.model.rms.repository.branch.BranchCriteria;
import ir.msob.manak.domain.model.rms.repositoryspecification.RepositorySpecification;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.util.SortedSet;
import java.util.TreeSet;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@Document(collection = Repository.DOMAIN_NAME)
@DomainInfo(domainName = Repository.DOMAIN_NAME_WITH_HYPHEN)
public class Repository extends DomainAbstract {
    @Transient
    public static final String DOMAIN_NAME = "Repository";
    @Transient
    public static final String DOMAIN_NAME_WITH_HYPHEN = "repository";
    @Serial
    private static final long serialVersionUID = -8938843863906151000L;
    @NotBlank
    private String name;
    private String description;
    @NotBlank
    private String path;

    /**
     * Tags associated with the document.
     */
    @Singular
    private SortedSet<String> tags = new TreeSet<>();

    /**
     * The specification describing the storage and connection details for this document.
     */
    @DBRef(lazy = true)
    @NotNull
    private RepositorySpecification specification;

    @ChildDomain(cdClass = Branch.class, ccClass = BranchCriteria.class)
    private SortedSet<Branch> branches = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = Characteristic.class, ccClass = CharacteristicCriteria.class)
    private SortedSet<Characteristic> characteristics = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = ObjectValidation.class, ccClass = ObjectValidationCriteria.class)
    private SortedSet<ObjectValidation> objectValidations = new TreeSet<>();

    @Singular
    @ChildDomain(cdClass = RelatedAction.class, ccClass = RelatedActionCriteria.class)
    private SortedSet<RelatedAction> relatedActions = new TreeSet<>();

    public Repository(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    public enum FN {
        name, description
    }
}