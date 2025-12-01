package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import com.fasterxml.jackson.annotation.JsonInclude;
import ir.msob.manak.domain.model.common.model.ParameterDescriptor;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class ResponseDescriptor {
    @Singular
    private List<ResponseStatus> statuses = new ArrayList<>();
    private ParameterDescriptor responseSchema;
    private boolean stream;
    @Singular
    private List<Example> examples = new ArrayList<>();
}
