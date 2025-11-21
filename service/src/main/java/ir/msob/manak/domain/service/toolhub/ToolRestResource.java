package ir.msob.manak.domain.service.toolhub;

import ir.msob.jima.core.commons.logger.Logger;
import ir.msob.jima.core.commons.logger.LoggerFactory;
import ir.msob.manak.core.model.jima.security.User;
import ir.msob.manak.core.service.jima.security.UserService;
import ir.msob.manak.domain.model.common.dto.InvokeRequest;
import ir.msob.manak.domain.model.common.dto.InvokeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.security.Principal;

@RestController
@RequestMapping(ToolRestResource.BASE_URI)
@RequiredArgsConstructor
public class ToolRestResource {

    public static final String BASE_URI = "/api/v1/tool";
    private static final Logger logger = LoggerFactory.getLogger(ToolRestResource.class);

    private final ToolService service;
    private final UserService userService;

    @PostMapping("invoke")
    public ResponseEntity<Mono<InvokeResponse>> invoke(@RequestBody InvokeRequest dto, Principal principal) {
        logger.info("REST request to invoke tool, ToolId: {}", dto.getToolId());
        User user = userService.getUser(principal);
        Mono<InvokeResponse> res = service.invoke(dto, user);
        return ResponseEntity.ok(res);
    }
}
