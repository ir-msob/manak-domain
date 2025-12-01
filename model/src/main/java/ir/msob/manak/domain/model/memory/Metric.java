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
public class Metric extends MemoryBase {
    private String formula;        // how to calculate
    private String unit;           // e.g. ms, %, score
    private String threshold;      // acceptable boundary
}
