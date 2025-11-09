package ir.msob.manak.domain.service.toolhub;

import ir.msob.manak.domain.model.toolhub.ToolExecutor;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ToolExecutorRegistry {

    private final Optional<List<ToolExecutor>> toolExecutors;
    @Getter
    private Map<String, ToolExecutor> executorMap = new HashMap<>();


    @PostConstruct
    private void init() {
        log.info("Starting initialization of ToolExecutorRegistry...");

        if (toolExecutors.isEmpty() || toolExecutors.get().isEmpty()) {
            log.warn("No ToolExecutor beans found in application context. Registry will be empty.");
            return;
        }

        List<ToolExecutor> executors = toolExecutors.get();
        log.info("Found {} ToolExecutor(s) to register", executors.size());

        // Log details about each executor before registration
        executors.forEach(executor -> {
            String toolName = executor.getToolDescriptor().getName();
            String toolVersion = executor.getToolDescriptor().getVersion();
            log.debug("Registering ToolExecutor: name='{}', version='{}'", toolName, toolVersion);
        });

        try {
            executorMap = executors.stream()
                    .collect(Collectors.toMap(
                            o -> o.getToolDescriptor().getToolId(),
                            h -> h,
                            (existing, replacement) -> {
                                log.warn("Duplicate ToolExecutor key detected: '{}'. Keeping the existing one.",
                                        existing.getToolDescriptor().getToolId());
                                return existing;
                            }));

            log.info("Successfully registered {} ToolExecutor(s) in registry", executorMap.size());
        } catch (Exception e) {
            log.error("Failed to initialize ToolExecutorRegistry", e);
            executorMap = new HashMap<>();
        }
    }
}