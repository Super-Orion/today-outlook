package com.orion.outlook.config.task;

import com.orion.outlook.common.utils.TraceIdUtil;
import java.util.Map;
import javax.annotation.Nonnull;
import org.slf4j.MDC;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author WCY
 * @since 2023-05-04
 */
public class MdcThreadPoolTaskExecutor extends ThreadPoolTaskExecutor {

    @Override
    public void execute(@Nonnull Runnable task) {
        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        super.execute(() -> {
            if (contextMap != null) {
                MDC.setContextMap(contextMap);
            } else {
                TraceIdUtil.setTraceId();
            }
            try {
                task.run();
            } finally {
                TraceIdUtil.clear();
            }
        });
    }
}
