package solutions.adapttech.classes.javaMasterClass;

public class SumOddRange {
    public static boolean isOdd (int number){
        if (number < 0){
            return false;
        } else if (number % 2 != 0){
            return true;
        }
        return false;
    }

}
