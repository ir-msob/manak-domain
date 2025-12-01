package ir.msob.manak.domain.model.common.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
public class TimeoutPolicy {
    private int timeoutMs;
    private boolean failFast;
    private int gracePeriodMs;
}
