package solutions.adapttech.classes.javaMasterClass;

import static java.lang.Math.PI;

public class AreaCalculator {
    public static double area = 0;

    public static double area(double radius) {
        if (radius < 0) {
            System.out.println("Invalid input");
            return -1.0;
        }
        area = (radius * radius) * PI;

        return area;
    }
        public static double area(double x, double y) {
            if (x < 0 || y < 0) {
                System.out.println("Invalid input");
                return -1.0;
            }
            area = x * y;
            return area;
    }
}
