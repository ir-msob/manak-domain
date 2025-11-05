package ir.msob.manak.domain.model.toolhub.dto;

import ir.msob.jima.core.commons.shared.ModelType;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvokeResponse extends ModelType {
    private String toolId;
    private Object res;
    private String error;
}