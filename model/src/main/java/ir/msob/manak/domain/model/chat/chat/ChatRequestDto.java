package ir.msob.manak.domain.model.chat.chat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.msob.jima.core.commons.domain.DomainInfo;
import ir.msob.jima.core.commons.domain.DtoInfo;
import ir.msob.jima.core.commons.shared.ModelType;
import ir.msob.manak.domain.model.common.ServiceName;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@DtoInfo(serviceName = ServiceName.AI, version = "v1")
@DomainInfo(domainName = ChatRequestDto.DOMAIN_NAME_WITH_HYPHEN)
public class ChatRequestDto extends ModelType {
    @JsonIgnore
    public static final String DOMAIN_NAME_WITH_HYPHEN = "chat";

    private String requestId;

    /**
     * Target model identifier (e.g. "ollama-llama3.2:3b" or "openai/gpt-4o").
     * Required when routing to different model providers.
     */
    @NotBlank
    private String model;

    /**
     * If true, the server is expected to enable tool callbacks (tool discovery + invocation).
     */
    @Builder.Default
    private boolean toolsEnabled = false;

    /**
     * Named tool ids that the client requests to be enabled for this session/request.
     * If empty, server decides.
     */
    @Builder.Default
    private List<String> enabledTools = new ArrayList<>();

    /**
     * Priority, shorthand single user message.
     * Kept for convenience clients that don't use role-based messages.
     */
    private String simpleMessage;

    /**
     * Role-based message list (ordered). If non-empty, this is used instead of simpleMessage.
     */
    @Builder.Default
    private List<Message> messages = new ArrayList<>();

    /**
     * Templates: commonly used templates for roles.
     * Each template can be INLINE, a RESOURCE path, or BASE64 encoded content.
     * Implementations should support resolving TemplateRef to a string before sending to model.
     */
    @Builder.Default
    private Map<Role, TemplateRef> templates = new EnumMap<>(Role.class);

    /**
     * Variables provided to template renderer (Mustache / FreeMarker / Handlebars).
     * Use triple-brace/raw insertion for code/log blocks when rendering.
     */
    @Builder.Default
    private Map<String, Object> templateVariables = new HashMap<>();

    /**
     * Typed model options (temperature, maxTokens, etc) + extensible map for provider-specific options.
     * Implementations should map these to concrete ChatOptions for each model provider.
     */
    @Builder.Default
    private ModelOptions options = new ModelOptions();

    /**
     * Optional expected-response schema (e.g. JSON Schema) — can be used to instruct the model or validate output.
     */
    private Object expectedResponseSchema;

    /**
     * Chat history / memory entries (transient). Usually converted to messages before sending.
     */
    @Builder.Default
    private List<HistoryEntry> history = new ArrayList<>();

    public enum Role {
        SYSTEM, USER, ASSISTANT, DEVELOPER, TOOL
    }

    public enum ContentType {INLINE, RESOURCE, BASE64}

    /**
     * Message with role and optional metadata.
     * Role follows ChatML-like semantics: SYSTEM / USER / ASSISTANT / DEVELOPER / TOOL
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Message {
        @NotNull
        private ContentType type;
        @NotNull
        private Role role;
        /**
         * content meaning:
         * - INLINE: the template string
         * - RESOURCE: resource path
         * - BASE64: base64 encoded bytes
         */
        @NotBlank
        private String content;
    }

    /**
     * Typed model options. Providers can extend or use additionalOptions for vendor-specific flags.
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class ModelOptions {
        /**
         * 0.0 - 2.0 typical (model dependent)
         */
        private Double temperature;
        /**
         * Max tokens (provider-specific semantics)
         */
        private Integer maxTokens;
        private Double topP;
        private Integer topK;
        private Double presencePenalty;
        private Double frequencyPenalty;

        /**
         * If true, the model is expected to return machine-readable JSON only.
         */
        private Boolean enforceJsonResponse;

        /**
         * Additional provider-specific options (raw map).
         */
        @Builder.Default
        private Map<String, Object> additionalOptions = new HashMap<>();
    }

    /**
     * History entry (transient). Use to reconstruct prior conversation or system memory.
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class HistoryEntry {
        @NotNull
        private ContentType type;
        @NotNull
        private Role role;
        /**
         * content meaning:
         * - INLINE: the template string
         * - RESOURCE: resource path
         * - BASE64: base64 encoded bytes
         */
        @NotBlank
        private String content;
        private Instant timestamp;
        @Builder.Default
        private Map<String, Object> meta = new HashMap<>();
    }

    /**
     * A template reference. The content may be:
     * - INLINE: template stored directly
     * - RESOURCE: path to resource
     * - BASE64: base64-encoded payload (for arbitrary complex payloads)
     */
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class TemplateRef {

        @NotNull
        private ContentType type;
        /**
         * content meaning:
         * - INLINE: the template string
         * - RESOURCE: resource path
         * - BASE64: base64 encoded bytes
         */
        @NotBlank
        private String content;

        /**
         * Optional metadata for template (version tag, filename, checksum).
         */
        @Builder.Default
        private Map<String, Object> meta = new HashMap<>();
    }

}