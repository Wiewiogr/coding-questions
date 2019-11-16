package pl.tw.dailycodingquestion.num1to10;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Implement a job scheduler which takes in a function f and an integer n, and calls f after n milliseconds.
 */

public class CodingQuestion10 {

    private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) throws InterruptedException {
        schedule(() -> System.out.println("dupa"), 100);
        Thread.sleep(10000);
    }

    public static void schedule(Runnable job, int millis) {
        executorService.schedule(job, millis, TimeUnit.MILLISECONDS);
    }
}
