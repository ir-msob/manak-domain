package ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RetryPolicy {
    private boolean enabled;
    private int maxAttempts;
    private long initialIntervalMs;
    private double multiplier;
    private long maxIntervalMs;
    private Set<Integer> retryOnStatus = new HashSet<>();
    private Set<String> retryOnErrorCodes = new HashSet<>();
}
