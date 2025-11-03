package ir.msob.manak.domain.model.aiagent.chat;

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
public class ChatResponse extends ModelType {
    private String modelSpecificationKey;
    private String message;
    private String response;
    private List<String> tools = new ArrayList<>();
}
