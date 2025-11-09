package ir.msob.manak.domain.service.toolhub.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.netty.handler.timeout.TimeoutException;
import ir.msob.manak.domain.model.toolhub.dto.InvokeRequest;
import ir.msob.manak.domain.model.toolhub.dto.InvokeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.codec.DecodingException;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.time.Instant;
import java.util.Arrays;

/**
 * Service class for building consistent and detailed error responses
 * when executing tools.
 */
public class ToolExecutorUtil {

    private static final Logger logger = LoggerFactory.getLogger(ToolExecutorUtil.class);
    private static final String DEFAULT_ERROR_MESSAGE = "An unexpected error occurred during tool execution.";
    private static final String DEFAULT_ERROR_CODE = "EXECUTION_ERROR";

    /**
     * Builds an error response for tool execution with exception details and default error code
     *
     * @param dto the invoke request DTO
     * @param e   the exception that occurred
     * @return Mono containing the error response
     */
    public static Mono<InvokeResponse> buildError(InvokeRequest dto, Throwable e) {
        return buildError(dto, e, DEFAULT_ERROR_CODE);
    }

    /**
     * Builds an error response for tool execution with custom error code
     *
     * @param dto  the invoke request DTO
     * @param e    the exception that occurred
     * @param code the error code
     * @return Mono containing the error response
     */
    public static Mono<InvokeResponse> buildError(InvokeRequest dto, Throwable e, String code) {
        String errorMsg = resolveErrorMessage(e);
        logger.error("Error invoking tool [{}]: {}", dto.getToolId(), errorMsg, e);
        return buildErrorResponse(dto, errorMsg, e.getStackTrace(), code);
    }

    /**
     * Builds an error response for tool execution with a custom message and default error code
     *
     * @param dto     the invoke request DTO
     * @param message the error message
     * @return Mono containing the error response
     */
    public static Mono<InvokeResponse> buildError(InvokeRequest dto, String message) {
        return buildError(dto, message, DEFAULT_ERROR_CODE);
    }

    /**
     * Builds an error response for tool execution with a custom message and error code
     *
     * @param dto     the invoke request DTO
     * @param message the error message
     * @param code    the error code
     * @return Mono containing the error response
     */
    public static Mono<InvokeResponse> buildError(InvokeRequest dto, String message, String code) {
        logger.warn("Returning error for tool [{}]: {}", dto.getToolId(), message);
        return buildErrorResponse(dto, message, null, code);
    }

    /**
     * Internal method to build error response with common logic
     *
     * @param dto        the invoke request DTO
     * @param message    the error message
     * @param stackTrace the stack trace (optional)
     * @param code       the error code
     * @return Mono containing the error response
     */
    private static Mono<InvokeResponse> buildErrorResponse(InvokeRequest dto, String message, StackTraceElement[] stackTrace, String code) {
        String toolId = dto.getToolId();
        String formattedMessage = buildErrorResponse(toolId, message);

        InvokeResponse.ErrorInfo.ErrorInfoBuilder errorBuilder = InvokeResponse.ErrorInfo.builder()
                .code(code)
                .message(formattedMessage)
                .details(dto.getParameters());

        if (stackTrace != null) {
            errorBuilder.stackTrace(Arrays.toString(stackTrace));
        }

        return Mono.just(InvokeResponse.builder()
                .id(dto.getId())
                .toolId(toolId)
                .error(errorBuilder.build())
                .executedAt(Instant.now())
                .build());
    }

    /**
     * Builds a full error response string including tool ID and a resolved message.
     *
     * @param toolId    unique tool identifier
     * @param throwable exception thrown during tool execution
     * @return formatted error response
     */
    public static String buildErrorResponse(String toolId, Throwable throwable) {
        return buildErrorResponse(toolId, resolveErrorMessage(throwable));
    }

    /**
     * Builds a full error response string with a custom message.
     *
     * @param toolId  unique tool identifier
     * @param message descriptive message of the error
     * @return formatted error response
     */
    public static String buildErrorResponse(String toolId, String message) {
        return String.format("Error executing tool '%s': %s", toolId, message);
    }

    /**
     * Resolves human-readable error message based on exception type.
     *
     * @param e exception to analyze
     * @return resolved message text
     */
    public static String resolveErrorMessage(Throwable e) {
        if (e == null) return DEFAULT_ERROR_MESSAGE;

        return switch (e) {
            case WebClientResponseException wcre -> formatWebClientResponse(wcre);
            case WebClientRequestException wcreq -> formatWebClientRequest(wcreq);
            case TimeoutException ignored -> "Request timed out while waiting for response.";
            case ConnectException ignored -> "Failed to connect to remote service.";
            case UnknownHostException ignored -> "Remote host could not be resolved.";
            case IllegalArgumentException iae -> "Invalid request: " + safeMessage(iae.getMessage());
            case DecodingException de -> "Failed to decode server response: " + safeMessage(de.getMessage());
            case JsonProcessingException jpe -> "Invalid JSON format: " + safeMessage(jpe.getOriginalMessage());
            default -> safeMessage(e.getMessage());
        };
    }

    private static String formatWebClientResponse(WebClientResponseException e) {
        String body = e.getResponseBodyAsString();
        String status = e.getStatusCode().toString();
        if (body.isBlank()) {
            body = "(empty response body)";
        }
        return String.format("HTTP %s: %s", status, body);
    }

    private static String formatWebClientRequest(WebClientRequestException e) {
        Throwable cause = e.getCause();
        if (cause instanceof TimeoutException) {
            return "Request timed out while connecting to server.";
        } else if (cause instanceof ConnectException) {
            return "Unable to connect to server.";
        } else if (cause instanceof UnknownHostException) {
            return "Unknown host: " + cause.getMessage();
        }
        return "WebClient request failed: " + safeMessage(e.getMessage());
    }

    private static String safeMessage(String message) {
        return (message == null || message.isBlank()) ? DEFAULT_ERROR_MESSAGE : message;
    }
}