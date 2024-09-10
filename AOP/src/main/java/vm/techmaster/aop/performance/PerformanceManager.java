package vm.techmaster.aop.performance;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class PerformanceManager {

    private final Map<String, Long> totalCallByMethod =
            new ConcurrentHashMap<>();
    private final Map<String, Long> totalProcessTimeByMethod =
            new ConcurrentHashMap<>();
    // không cần thiêết lắm và giảm hiệu năng vì ConcurrentHashMap  đã synchronizeed sẳn rồi
    public synchronized void record(String method, long processTime) {
        totalCallByMethod.compute(method, (k, v) -> v != null ? v + 1 : 1);
        totalProcessTimeByMethod.compute(
                method,
                (k, v) -> v != null ? v + processTime : processTime
        );
    }

    public String getSummary() {
        return "totalCallByMethod: " + totalCallByMethod
                + "\n"
                + "totalProcessTimeByMethod: " + totalProcessTimeByMethod;
    }
}