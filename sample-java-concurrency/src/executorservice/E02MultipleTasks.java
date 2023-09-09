package executorservice;

/**
 * Running a task asynchronously.
 */
public class E02MultipleTasks {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new E01SingleTask.Task());
            thread.start();
        }
        System.out.println("Thread name: " + Thread.currentThread().getName());
    }

    static class Task implements Runnable {
        public void run() {
            System.out.println("Thread name: " + Thread.currentThread().getName());
        }
    }
}
