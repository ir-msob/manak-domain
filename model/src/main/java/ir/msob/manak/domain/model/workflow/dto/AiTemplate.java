package ir.msob.manak.domain.model.workflow.dto;

import ir.msob.manak.domain.model.chat.chat.ChatRequestDto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AiTemplate {
    private List<Template> templates = new ArrayList<>();

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Template {
        private ChatRequestDto.ContentType type;
        private ChatRequestDto.Role role;
        private String content;
    }
}
