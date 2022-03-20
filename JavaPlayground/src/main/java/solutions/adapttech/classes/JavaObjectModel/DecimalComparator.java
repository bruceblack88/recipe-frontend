package solutions.adapttech.classes.JavaObjectModel;

public class DecimalComparator {
    public static boolean areEqualByThreeDecimalPlaces(double x, double y){
        int a = (int) (x * 1000);
        int b = (int) (y * 1000);
        if (a == b) {
            return true;
        }
        else return false;
        }
    public static void main(String[] args) {
        DecimalComparator test = new DecimalComparator();
        areEqualByThreeDecimalPlaces(34.54321, 34.54342);
    }
}


