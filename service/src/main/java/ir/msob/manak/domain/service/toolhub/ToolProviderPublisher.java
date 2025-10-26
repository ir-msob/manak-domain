package ir.msob.manak.domain.service.toolhub;

import ir.msob.jima.core.commons.exception.runtime.CommonRuntimeException;
import ir.msob.jima.core.commons.logger.Logger;
import ir.msob.jima.core.commons.logger.LoggerFactory;
import ir.msob.jima.crud.api.kafka.client.domain.DomainCrudKafkaAsyncClient;
import ir.msob.manak.core.service.jima.security.UserService;
import ir.msob.manak.domain.model.toolhub.ToolHandler;
import ir.msob.manak.domain.model.toolhub.ToolProviderHandler;
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

    private final Optional<List<ToolHandler>> handlers;
    private final Optional<ToolProviderHandler> toolProviderHandler;
    private final UserService userService;
    private final DomainCrudKafkaAsyncClient kafkaClient;

    @PostConstruct
    public void send() {
        log.info("🚀 ToolProducer started producing ToolProvider message...");

        if (handlers.isPresent() && toolProviderHandler.isPresent()) {
            try {
                // -------------------------------
                // Collect all ToolDescriptors from handlers
                // -------------------------------
                SortedSet<ToolDescriptor> tools = handlers.get()
                        .stream()
                        .map(ToolHandler::getToolDescriptor)
                        .collect(Collectors.toCollection(TreeSet::new));
                log.info("🛠 Collected {} tool descriptors from handlers.", tools.size());

                // -------------------------------
                // Build ToolProvider
                // -------------------------------
                ToolProviderDto provider = toolProviderHandler.get().getToolProvider();
                provider.setTools(tools);
                log.info("📦 ToolProvider '{}' built with {} tools.", provider.getName(), tools.size());

                // -------------------------------
                // Send to Kafka
                // -------------------------------
                kafkaClient.save(
                        ToolProviderDto.class,
                        provider,
                        userService.getSystemUser()
                );
                log.info("✅ ToolProvider message successfully sent to Kafka for '{}'.", provider.getName());

            } catch (Exception e) {
                log.error("❌ Failed to produce ToolProvider message", e);
                throw new CommonRuntimeException("Failed to produce ToolProvider message", e);
            }
        }
    }
}
