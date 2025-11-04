package ir.msob.manak.domain.service.toolhub;

public class ToolExecutorUtl {

    public static String buildErrorResponse(String toolId, Throwable e) {
        return String.format("Error executing tool '%s': %s", toolId, e.getMessage());
    }
}
