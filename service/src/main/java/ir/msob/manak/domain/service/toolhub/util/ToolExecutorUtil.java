package ir.msob.manak.domain.service.toolhub.util;

public class ToolExecutorUtil {

    public static String buildErrorResponse(String toolId, Throwable e) {
        return String.format("Error executing tool '%s': %s", toolId, e.getMessage());
    }
}
