package ir.msob.manak.domain.model.toolhub.dto;

import ir.msob.jima.core.commons.shared.ModelType;
import lombok.*;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvokeResponse extends ModelType {
    private String toolId;
    private Serializable result;
    private String error;
}