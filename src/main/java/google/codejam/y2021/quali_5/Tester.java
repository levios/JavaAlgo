package google.codejam.y2021.quali_5;

public class Tester {


    public static void main(String[] args) {
        for (double i = -6.0; i < 6.0; i+=0.1) {
            System.out.println(f(i, 0.0));
        }
    }

    static double f(double s, double q) {
        return 1.0 / (1.0 + Math.pow(Math.E, -1.0 * (s-q)));
    }
}
