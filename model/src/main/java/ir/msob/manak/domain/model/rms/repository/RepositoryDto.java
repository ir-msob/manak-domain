package ir.msob.manak.domain.model.rms.repository;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.manak.core.model.jima.domain.Dto;
import lombok.*;

import java.io.Serial;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RepositoryDto extends Repository implements Dto {
    @Serial
    private static final long serialVersionUID = -8938843865456070000L;

    @Builder
    public RepositoryDto(String id, String name, String description) {
        super(id, name, description);
    }

}