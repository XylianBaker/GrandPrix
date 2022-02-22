package methods;

public class Pi implements Calculation{
    // A private variable that is used to store the value of the point of pi.
    private int pointOfPi;

    // This is the constructor of the class. It is used to initialize the value of the point of pi.
    public Pi(int pointOfPi) {
        this.pointOfPi = pointOfPi;
    }

    /**
     * A method that is used to calculate the value of pi.
     */
    @Override
    public void execute() {
        double pi = 0;
        double s = 1;

        for (int i = 0; i < pointOfPi; i+=2) {
            pi += s/i;
            s = -s;
        }
    }
}
