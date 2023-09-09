package executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class E03ExecutorService {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 100; i++) {
            executorService.execute(new Task());
        }

        System.out.println("Thread name: " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }
}
