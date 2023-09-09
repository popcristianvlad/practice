package executorservice;

/**
 * Running a task asynchronously.
 */
public class E01SingleTask {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Task());
        thread1.start();
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }
}
