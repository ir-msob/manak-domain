package ir.msob.manak.domain.service.toolhub;

import ir.msob.jima.core.commons.exception.runtime.CommonRuntimeException;
import ir.msob.jima.core.commons.logger.Logger;
import ir.msob.jima.core.commons.logger.LoggerFactory;
import ir.msob.jima.crud.api.kafka.client.domain.DomainCrudKafkaAsyncClient;
import ir.msob.manak.core.service.jima.security.UserService;
import ir.msob.manak.domain.model.toolhub.ToolExecutor;
import ir.msob.manak.domain.model.toolhub.ToolProviderDescriptor;
import ir.msob.manak.domain.model.toolhub.toolprovider.ToolProviderDto;
import ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor.ToolDescriptor;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToolProviderPublisher {

    private static final Logger log = LoggerFactory.getLogger(ToolProviderPublisher.class);

    private final Optional<List<ToolExecutor>> toolExecutors;
    private final Optional<ToolProviderDescriptor> toolProviderDescriptor;
    private final UserService userService;
    private final DomainCrudKafkaAsyncClient kafkaClient;

    @PostConstruct
    public void send() {
        int executorCount = toolExecutors.isPresent() ? toolExecutors.map(List::size).orElse(0) : 0;
        boolean hasExecutors = toolExecutors.isPresent() && !toolExecutors.get().isEmpty();
        boolean hasDescriptor = toolProviderDescriptor.isPresent();

        log.info("Initializing ToolProviderPublisher: toolExecutorsPresent={}, toolExecutorsCount={}, toolProviderDescriptorPresent={}",
                hasExecutors, executorCount, hasDescriptor);

        if (toolExecutors.isPresent() && !toolExecutors.get().isEmpty() && toolProviderDescriptor.isPresent()) {
            try {
                // Step 1: Collect all tool descriptors from registered executors
                SortedSet<ToolDescriptor> tools = toolExecutors.get()
                        .stream()
                        .map(ToolExecutor::getToolDescriptor)
                        .collect(Collectors.toCollection(TreeSet::new));
                log.info("Collected {} tool descriptors from executors.", tools.size());

                // Step 2: Build ToolProvider DTO with descriptors
                ToolProviderDto provider = toolProviderDescriptor.get().getToolProvider();
                provider.setTools(tools);
                log.info("Built ToolProvider '{}' containing {} tools.", provider.getName(), tools.size());

                // Step 3: Publish ToolProvider DTO to Kafka
                kafkaClient.save(ToolProviderDto.class, provider, userService.getSystemUser());
                log.info("ToolProvider '{}' successfully published to Kafka.", provider.getName());

            } catch (Exception e) {
                log.error("Failed to publish ToolProvider message to Kafka.", e);
                throw new CommonRuntimeException("Error publishing ToolProvider message to Kafka", e);
            }
        } else {
            log.info("ToolProviderPublisher skipped: missing ToolExecutors or ToolProviderDescriptor.");
        }
    }
}
