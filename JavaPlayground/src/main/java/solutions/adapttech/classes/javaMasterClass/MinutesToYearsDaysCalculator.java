package solutions.adapttech.classes.javaMasterClass;

public class MinutesToYearsDaysCalculator {

    public static void printYearsAndDays(long minutes) {
        if (minutes < 0) {
            System.out.println("Invalid Value");
        } else{
        long hour = minutes / 60;
        long days = minutes / 1440;
        long years = minutes / 525600;
        long remainingDays = days % 365;

        System.out.println(String.format("%d min = %d y and %d d", minutes, years, remainingDays));}
    }

    public static void main(String[] args) {
        MinutesToYearsDaysCalculator test = new MinutesToYearsDaysCalculator();
        test.printYearsAndDays(525600);
        test.printYearsAndDays(1051200);
        test.printYearsAndDays(561600);

    }
}
