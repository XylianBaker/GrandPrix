package methods;

public record Pi(int iterations) implements Calculation {
    /**
     * A method that is used to calculate the value of pi.
     */
    @Override
    public void execute() {
        double pi = 0;
        double s = 1;
        final int end = iterations * 2 + 1;

        for (int i = 1; i < end; i += 2) {
            pi += s / i;
            s = -s;
        }
    }
}
