package com.orion.outlook.common.utils;

import java.util.UUID;
import org.slf4j.MDC;

/**
 * 链路id工具.
 * @author WCY
 * @since 2023-05-04
 */
public class TraceIdUtil {

    private TraceIdUtil() {}

    private static final String TRACE_ID = "traceId";

    public static void setTraceId() {
        MDC.put(TRACE_ID, UUID.randomUUID().toString());
    }

    public static void setTraceId(String traceId) {
        MDC.put(TRACE_ID, traceId);
    }

    public static String getTraceId() {
        return MDC.get(TRACE_ID);
    }

    public static void clear() {
        MDC.clear();
    }
}
