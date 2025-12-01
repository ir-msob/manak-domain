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
public class Pattern extends MemoryBase {
    private PatternType patternType;
    private String problem;
    private String solution;
    private String consequences; // pros & cons

    public enum PatternType {
        DESIGN,
        ARCHITECTURAL,
        CODE,
        PROCESS
    }
}
