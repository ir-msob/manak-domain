package ir.msob.manak.domain.model.chat.chat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.jima.core.commons.shared.ModelType;
import ir.msob.manak.domain.model.common.ServiceName;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@DtoInfo(serviceName = ServiceName.CHAT, version = "v1")
@DomainInfo(domainName = ChatRequestDto.DOMAIN_NAME_WITH_HYPHEN)
public class ChatRequestDto extends ModelType {
    @JsonIgnore
    public static final String DOMAIN_NAME_WITH_HYPHEN = "chat";
    private String modelSpecificationKey;
    private String message;
    private List<String> tools = new ArrayList<>();
    private Object schema;
}
