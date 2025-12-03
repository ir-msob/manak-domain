package ir.msob.manak.domain.service.properties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = "manak")
public class ManakProperties {

    private MemoryProperties memory = new MemoryProperties();

}