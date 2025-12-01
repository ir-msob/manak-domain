package ir.msob.manak.domain.model.memory;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
public class Strategy extends MemoryBase {
    private String objective;
    private List<String> steps = new ArrayList<>();
    private List<String> prerequisites = new ArrayList<>();
}
