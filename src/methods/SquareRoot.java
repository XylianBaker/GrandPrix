package methods;

public class SquareRoot implements Calculation{
    // Declaring a private variable called `root` that is of type `long`.
    private long root;

    // This is the constructor of the class. It is used to initialize the class.
    public SquareRoot(long n) {
        this.root = n;
    }

    /**
     * Find the square root of a number
     */
    @Override
    public void execute() {
        float a = this.root;
        float b = 1;
        double e = 0.000001;
        while (a - b > e) {
            a = (a + b) / 2;
            b = this.root / a;
        }
        System.out.println(a);
    }
}
