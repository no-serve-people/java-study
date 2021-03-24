package com.tracenull.j20210324.testSystemMilliSpeed;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 缓慢的System.currentTimeMillis() - 疑问号
 * https://juejin.cn/post/6942539017476898847?utm_source=gold_browser_extension
 */
public class SystemClock {
    private final AtomicLong now;
    private static ScheduledExecutorService scheduler;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                if (scheduler != null) {
                    scheduler.shutdown();
                }
            }
        });
    }


    private SystemClock() {
        this.now = new AtomicLong(System.currentTimeMillis());

        Executors.newSingleThreadExecutor(runnable -> {
            Thread thread = new Thread(runnable, "SystemClockScheduled");
            thread.setDaemon(true);
            return thread;
        });

        scheduler.scheduleAtFixedRate(() -> now.set(System.currentTimeMillis()), 1, 1, TimeUnit.MILLISECONDS);

    }

    public static long now() {
        return getInstance().now.get();
    }

    private enum SystemClockEnum {
        SYSTEM_CLOCK;
        private final SystemClock systemClock;

        SystemClockEnum() {
            systemClock = new SystemClock();
        }

        public SystemClock getIntance() {
            return systemClock;
        }
    }

    private static SystemClock getInstance() {
        return SystemClockEnum.SYSTEM_CLOCK.getIntance();
    }
}
