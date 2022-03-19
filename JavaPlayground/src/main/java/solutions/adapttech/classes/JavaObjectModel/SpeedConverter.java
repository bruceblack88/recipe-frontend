package solutions.adapttech.classes.JavaObjectModel;

public class SpeedConverter {
    public SpeedConverter() {
    }

    static long milesPerHour;

    // write your code here
    public static long toMilesPerHour(double kilometersPerHour) {

        if (kilometersPerHour < 0) {
            return -1;
        }
        milesPerHour = Math.round(kilometersPerHour * 1.609);

        return milesPerHour;
    }

    public static void printConversion(double kilometersPerHour) {
        long milesPerHour = Math.round(kilometersPerHour * 1.609);
        if (kilometersPerHour < 0) {
            System.out.println("Invalid Value");
        } else {
            System.out.println(kilometersPerHour + " km/h = " + milesPerHour + " mi/h");
        }

    }


}