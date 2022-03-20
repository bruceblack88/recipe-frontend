package solutions.adapttech.classes.JavaObjectModel;

public class LeapYear {
    public static boolean isLeapYear(int year) {
        if (year > 0 && year <= 9999) {
            return (year % 4 == 0 && year % 100 !=0 || year % 400 == 0 && year % 100 ==0);
        } else return false;
    }
}

