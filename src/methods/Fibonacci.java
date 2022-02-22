package methods;

public class Fibonacci implements Calculation{
    // Declaring a private variable called `precision` that is of type `long`.
    private long precision;

    // This is a constructor that takes a long as an argument and sets the precision to that value.
    public Fibonacci(long n) {
        this.precision = n;
    }

    /**
     * Given a number, return the nth fibonacci number
     *
     * @param n The number of the Fibonacci number to be returned.
     * @return The fibonacci number of the input.
     */
    public long fibonacci(long n) {
        if ((n == 0) || (n == 1)) return n;
        else return fibonacci(n -1) + fibonacci(n - 2);
    }


    @Override
    public void execute() {
        fibonacci(this.precision);
    }
}
