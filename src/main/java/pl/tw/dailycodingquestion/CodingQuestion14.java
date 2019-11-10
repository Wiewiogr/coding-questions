package pl.tw.dailycodingquestion;

/**
 * The area of a circle is defined as πr^2.
 * Estimate π to 3 decimal places using a Monte Carlo method.
 * <p>
 * Hint: The basic equation of a circle is x2 + y2 = r2.
 */
public class CodingQuestion14 {

    public static void main(String[] args) {
        System.out.println(estimate(10));
        System.out.println(estimate(100));
        System.out.println(estimate(1000));
        System.out.println(estimate(10000));
        System.out.println(estimate(100000));
        System.out.println(estimate(1000000));
        System.out.println(estimate(10000000));
        System.out.println(estimate(100000000));
        System.out.println(estimate(1000000000));
    }

    public static double estimate(int iterations) {
        int pointsInsideCircle = 0;
        int pointsTotal = 0;

        for (int i = 0; i < iterations; i++) {
            double x = Math.random() * 2 - 1;
            double y = Math.random() * 2 - 1;
            if (inCircle(x, y)) {
                pointsInsideCircle++;
            }
            pointsTotal++;
        }

        return pointsInsideCircle * 4.0 / pointsTotal;
    }

    private static boolean inCircle(double x, double y) {
        return x * x + y * y <= 1;
    }
}
