package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStatus {
    private String status;
    private String description;
    private String contentType;
}
