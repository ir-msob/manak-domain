package ir.msob.manak.domain.service.toolhub;

import ir.msob.jima.core.commons.exception.runtime.CommonRuntimeException;
import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.domain.model.toolhub.ToolHandler;
import ir.msob.manak.domain.model.toolhub.dto.InvokeRequest;
import ir.msob.manak.domain.model.toolhub.dto.InvokeResponse;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToolRegistry {

    private final Optional<List<ToolHandler>> handlers;
    private Map<String, ToolHandler> handlerMap = new HashMap<>();

    @PostConstruct
    private void init() {
        handlers.ifPresent(toolHandlers -> handlerMap = toolHandlers
                .stream()
                .collect(Collectors.toMap(o -> o.getToolDescriptor().getKey(), h -> h)));
    }

    public Mono<InvokeResponse> invoke(InvokeRequest request, User user) {
        ToolHandler handler = handlerMap.get(request.getToolId());
        if (handler == null) {
            return Mono.error(new CommonRuntimeException("Tool not supported: " + request.getToolId()));
        }
        return handler.execute(request, user);
    }
}
