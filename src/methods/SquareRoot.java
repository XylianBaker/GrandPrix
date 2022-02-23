package methods;

public class SquareRoot implements Calculation{
    // Making the precision variable private and final.
    private final double precision;

    // This is a constructor. It is used to initialize the object.
    public SquareRoot(double precision) {
        this.precision = precision;
    }

    /**
     * Find the square root of a number
     */
    @Override
    public void execute() {
        double a = 1000;
        double b = 1;
        while (a - b > precision) {
            a = (a + b) / 2;
            b = this.precision / a;
        }
    }
}
