package ir.msob.manak.domain.model.util;

import ir.msob.jima.core.commons.exception.runtime.CommonRuntimeException;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public final class VariableUtils {

    private VariableUtils() {
    }

    /**
     * Returns the string representation of the object or null if the object is null.
     */
    public static String safeString(Object o) {
        return Objects.toString(o, null);
    }

    /**
     * Converts an object to Map<String, String>, throws exception if conversion fails.
     */
    @SuppressWarnings("unchecked")
    public static Map<String, String> safeMapStringString(Object o) {
        if (o == null) return Collections.emptyMap();
        if (o instanceof Map<?, ?> map) {
            try {
                return (Map<String, String>) map;
            } catch (ClassCastException ex) {
                throw new CommonRuntimeException("Cannot convert object to Map<String, String>", ex);
            }
        }
        throw new CommonRuntimeException("Object is not a Map: " + o.getClass());
    }

    /**
     * Converts an object to Map<String, Object>, throws exception if conversion fails.
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> safeMapStringObject(Object o) {
        if (o == null) return Collections.emptyMap();
        if (o instanceof Map<?, ?> map) {
            try {
                return (Map<String, Object>) map;
            } catch (ClassCastException ex) {
                throw new CommonRuntimeException("Cannot convert object to Map<String, Object>", ex);
            }
        }
        throw new CommonRuntimeException("Object is not a Map: " + o.getClass());
    }

    /**
     * Converts an object to int, returns defaultValue if conversion fails.
     */
    public static int safeInt(Object o, int defaultValue) {
        if (o == null) return defaultValue;
        if (o instanceof Number number) return number.intValue();
        try {
            return Integer.parseInt(o.toString());
        } catch (NumberFormatException ex) {
            throw new CommonRuntimeException("Cannot convert object to int: " + o, ex);
        }
    }

    /**
     * Converts an object to List<T>, throws exception if conversion fails.
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> safeList(Object o) {
        if (o == null) return Collections.emptyList();
        if (o instanceof List<?> list) {
            try {
                return (List<T>) list;
            } catch (ClassCastException ex) {
                throw new CommonRuntimeException("Cannot convert object to List", ex);
            }
        }
        throw new CommonRuntimeException("Object is not a List: " + o.getClass());
    }
}