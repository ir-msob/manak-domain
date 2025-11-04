package ir.msob.manak.domain.model.toolhub;

import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.domain.model.toolhub.dto.InvokeRequest;
import ir.msob.manak.domain.model.toolhub.dto.InvokeResponse;
import ir.msob.manak.domain.model.toolhub.toolprovider.tooldescriptor.ToolDescriptor;
import reactor.core.publisher.Mono;

public interface ToolExecutor {
    ToolDescriptor getToolDescriptor();

    Mono<InvokeResponse> execute(InvokeRequest request, User user);
}