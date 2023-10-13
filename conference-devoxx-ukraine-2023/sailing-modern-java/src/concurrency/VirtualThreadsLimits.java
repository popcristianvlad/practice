package concurrency;

import java.time.Duration;
import java.time.Instant;

public class VirtualThreadsLimits {

    private final static Duration EMULATE_WORK_FOR = Duration.ofSeconds(10);

    public static void main(String[] args) throws InterruptedException {
        Instant start = Instant.now();
        Thread lastThread = null;

        int maxThreadNo = 1_000_000;
        for (int i = 0; i <= maxThreadNo; i++) {
            lastThread = createThread(i);
            lastThread.start();
            if (i % 5_000 == 0) {
                System.out.printf("Current count %d%n", i);
            }
        }
        lastThread.join();

        Instant stop = Instant.now();
        Duration took = Duration.between(start, stop);

        System.out.printf("Finished running %d threads; took %s%n", maxThreadNo, took);
    }

    private static Thread createThread(int i) {
        Runnable job = () -> blockingOperation(i);
        return Thread.ofPlatform().unstarted(job);
    }

    static void blockingOperation(int task) {
        // System.out.printf("Task: %6d, thread %s%n", task, Thread.currentThread());
        sneakySleep(EMULATE_WORK_FOR);
    }

    public static void sneakySleep(Duration d) {
        try {
            Thread.sleep(d);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}