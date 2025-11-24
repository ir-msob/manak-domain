package ir.msob.manak.domain.model.worker;

import ir.msob.manak.domain.model.workflow.WorkerExecutionStatus;

import java.util.Map;

import static ir.msob.manak.domain.model.worker.Constants.WORKER_EXECUTION_ERROR_KEY;
import static ir.msob.manak.domain.model.worker.Constants.WORKER_EXECUTION_STATUS_KEY;

public class WorkerUtils {
    private WorkerUtils() {
    }

    public static Map<String, Object> prepareErrorResult(String errorMessage) {
        return Map.of(
                WORKER_EXECUTION_STATUS_KEY, WorkerExecutionStatus.ERROR,
                WORKER_EXECUTION_ERROR_KEY, errorMessage
        );
    }

    public static Map<String, Object> prepareErrorResult(Object jobKey, Throwable ex) {
        return prepareErrorResult(prepareErrorMessage(jobKey, ex));
    }

    public static String prepareErrorMessage(Object jobKey, Throwable ex) {
        return String.format(
                "Worker execution failed for job '%s'. Error Type: %s. Message: %s",
                jobKey,
                ex.getClass().getSimpleName(),
                ex.getMessage()
        );
    }
}
