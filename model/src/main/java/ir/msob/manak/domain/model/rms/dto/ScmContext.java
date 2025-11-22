package ir.msob.manak.domain.model.rms.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ScmContext {
    private String repository;
    private String authToken;
}
