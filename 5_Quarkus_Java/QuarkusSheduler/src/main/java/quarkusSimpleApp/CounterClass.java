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
//    private final static String CRON = "0 51,52,53,54 * ? * * *";
//    private final static String CRON = "0 0 0 * * ?";


    @Scheduled(every="10s")
    void increment(ScheduledExecution execution) {
        everyThreeSeconds.incrementAndGet();
        System.out.println("Each Three Seconds = " + everyThreeSeconds);
        System.out.println(execution.getScheduledFireTime());
        System.out.println(execution.getFireTime());
    }

    @Scheduled(cron = CRON)
    void cronJob(ScheduledExecution execution) {
        counter.incrementAndGet();
        System.out.println("TIMER = " + counter);
        System.out.println(execution.getScheduledFireTime());
        System.out.println(execution.getFireTime());
    }
}
