import methods.Calculation;

public record ThreadRunner(Operator latch, Calculation method) implements Runnable {

    /**
     * The run() method is executed by the thread that created the thread pool.
     * It waits for the latch to be ready, then executes the method, and then waits for the latch to be finished
     */
    @Override
    public void run() {
        latch.ready();
        System.out.println(Thread.currentThread().getName() + " is ready.");
        latch.await();
        for (int i = 0; i != 3; i++) {
            long before = System.currentTimeMillis();
            this.method.execute();
            long after = System.currentTimeMillis();
            latch.getQueue().add(Thread.currentThread().getName() + " finished round: " + i + " in: " + (after - before + "ms."));
        }
        latch.finished();
    }
}
