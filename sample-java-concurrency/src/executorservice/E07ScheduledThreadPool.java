package executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import static java.util.concurrent.TimeUnit.SECONDS;

public class E07ScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

        service.schedule(new Task(), 10, SECONDS);
        service.scheduleAtFixedRate(new Task(), 15, 10, SECONDS);
        service.scheduleWithFixedDelay(new Task(), 15, 10, SECONDS);
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }
}
