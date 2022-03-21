import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;

public class Operator {
    // A data structure that is thread safe.
    private BlockingDeque<String> queue;
    private final CopyOnWriteArrayList<String> ranking = new CopyOnWriteArrayList<>();
    // A counter that keeps track of the number of threads that have finished.
    private int signals = 0;
    private int capacity = 0;

    /**
     * This function is called when the user clicks the "Ready" button
     */
    public void ready() {signals++;}

    /**
     * Wait until the number of signals is equal to the capacity
     */
    public synchronized void await() {
        while(this.capacity != this.signals) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Wait until the number of signals is equal to the capacity
     *
     * @param capacity The maximum number of items that can be stored in the queue.
     */
    public synchronized void wait(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedBlockingDeque<>(capacity*3);
        while (signals != this.capacity) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * It returns the queue.
     *
     * @return The queue is being returned.
     */
    public BlockingDeque<String> getQueue() {return this.queue;}

    /**
     * Add the current thread to the ranking list and print out the ranking
     */
    public synchronized void finished() {
        this.ranking.add(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName() + " finished. #" + (this.ranking.indexOf(Thread.currentThread().getName()) +1));
    }
}
