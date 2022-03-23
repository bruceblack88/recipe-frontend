package solutions.adapttech.classes.javaMasterClass;

public class NumberPalindrome {

    public static boolean isPalindrome(int number) {
        int reversedNumber = 0;
        int originalNumber = number;
        int remainder;
        while (number != 0) {
            remainder = number % 10;
            reversedNumber = reversedNumber * 10 + remainder;
            number /= 10;
        }
        if (originalNumber == reversedNumber) {
            return true;
        } else {
            return false;
        }
    }
}
