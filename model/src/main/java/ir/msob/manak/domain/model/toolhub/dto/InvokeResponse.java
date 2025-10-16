package ir.msob.manak.domain.model.toolhub.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvokeResponse {
    private String toolId;
    private Object result;
    private String error;
}