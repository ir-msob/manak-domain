package ir.msob.manak.domain.model.ai.chat;

import ir.msob.jima.core.commons.shared.ModelType;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ChatResponseDto extends ModelType {
    private String modelSpecificationKey;
    private String message;
    private String response;
    private List<String> tools = new ArrayList<>();
    private Object schema;
}
