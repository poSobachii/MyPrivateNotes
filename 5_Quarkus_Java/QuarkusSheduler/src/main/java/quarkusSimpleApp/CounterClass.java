package quarkusSimpleApp;

import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.ScheduledExecution;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class CounterClass {

    public static AtomicInteger counter = new AtomicInteger();
    private static AtomicInteger everyThreeSeconds = new AtomicInteger();


    private final static String CRON = "* * * * * ? *";


    @Scheduled(every="3s")
    void increment(ScheduledExecution execution) {
        everyThreeSeconds.incrementAndGet();
        System.out.println("Each Three Seconds = " + everyThreeSeconds);
        System.out.println(execution.getScheduledFireTime());
    }

    @Scheduled(cron = CRON)
    void cronJob() {
        counter.incrementAndGet();
        System.out.println("TIMER = " + counter);
    }
}
