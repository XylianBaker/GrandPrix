package methods;

public record SquareRoot(double precision) implements Calculation {

    /**
     * Find the square root of a number
     */
    @Override
    public void execute() {
        double x = this.precision * 10 * 10d;
        for (int i = 0; i < this.precision; i++) {
            x = 1d / 2 * (x * 2 / x);
        }
    }
}
