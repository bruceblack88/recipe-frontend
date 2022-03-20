package solutions.adapttech.classes.javaMasterClass;

public class BarkingDog {

    public static boolean shouldWakeUp(boolean barking, int hourOfDay) {
        if (hourOfDay < 8 || hourOfDay > 22) {
            if (hourOfDay < 0 || hourOfDay > 23) {
                return false;
            }
            return barking;
        }
        return false;
    }
}
