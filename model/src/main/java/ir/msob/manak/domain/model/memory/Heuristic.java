package ir.msob.manak.domain.model.memory;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Heuristic extends MemoryBase {
    private String guideline;
    private String typicalUseCases;

}
