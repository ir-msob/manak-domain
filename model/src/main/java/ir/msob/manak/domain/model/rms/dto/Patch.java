package ir.msob.manak.domain.model.rms.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Patch {
    private String diff;
}
