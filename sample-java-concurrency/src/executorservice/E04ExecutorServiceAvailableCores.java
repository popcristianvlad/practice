package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E04ExecutorServiceAvailableCores {

    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(coreCount);

        for (int i = 0; i < 100; i++) {
            executorService.execute(new CPUIntensiveTask());
        }

        System.out.println("Thread name: " + Thread.currentThread().getName());
    }

    static class CPUIntensiveTask implements Runnable {
        public void run() {
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }
}
