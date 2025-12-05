package ir.msob.manak.domain.model.ai.summarizer;

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
public class SummarizerResponseDto extends ModelType {
    private String requestId;
    private String model;
    private String finalSummary;
    @Builder.Default
    private List<String> inputSummaries = new ArrayList<>();
}
