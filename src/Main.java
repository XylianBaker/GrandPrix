import methods.Fibonacci;
import methods.Pi;
import methods.SquareRoot;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        // Creating a new instance of the `Operator` class.
        Operator latch = new Operator();

        // It creates a new instance of the `ThreadRunner` class and passes the `latch` object and the `method` object to
        // it.
        ThreadRunner runner1 = new ThreadRunner(latch, new Fibonacci(44));
        ThreadRunner runner2 = new ThreadRunner(latch, new Pi(694200000));
        ThreadRunner runner3 = new ThreadRunner(latch, new SquareRoot(Integer.MAX_VALUE/5));

        // It creates a new instance of the `Thread` class and passes the `runner` object and the `name` to it.
        Thread thread1 = new Thread(runner1, "Runner1");
        Thread thread2 = new Thread(runner2, "Runner2");
        Thread thread3 = new Thread(runner3, "Runner3");

        // It starts the threads.
        thread1.start();
        thread2.start();
        thread3.start();

        // Waiting for the threads to finish their execution.
        latch.wait(3);

        // A loop that keeps running until the queue is empty.
        while (true) {
            try {
                System.out.println(latch.getQueue().takeLast());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
