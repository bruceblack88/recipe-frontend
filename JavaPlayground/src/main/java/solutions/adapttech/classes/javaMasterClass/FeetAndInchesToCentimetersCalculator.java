package solutions.adapttech.classes.javaMasterClass;

public class FeetAndInchesToCentimetersCalculator {
    public static double centimeters;

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if (feet < 0 || inches < 0 && inches > 12) {
            return -1;
        } else {
            centimeters = (feet * 12) * 2.54;
            centimeters += inches * 2.54;
            System.out.println(feet + "feet: ");
            return centimeters;
        }

    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches < 0) {
            return -1;
        } else {
            double feet = (int) inches / 12;
            double remainingInches = (int) inches % 12;
            System.out.println(inches + " inches = " + centimeters);
            return calcFeetAndInchesToCentimeters(feet, remainingInches);
        }
    }

    public static void main(String[] args) {
        FeetAndInchesToCentimetersCalculator test = new FeetAndInchesToCentimetersCalculator();
        test.calcFeetAndInchesToCentimeters(11);
        test.calcFeetAndInchesToCentimeters(2.0, 3.0);
    }
}
