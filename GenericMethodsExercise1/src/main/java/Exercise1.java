 /*
Bruce Black
CSIS 505
Software Development
Generic Methods and Classes Exercise 1
June 20, 2021
*/

public class Exercise1 {

    public static <T> boolean equalsBlack(T element1, T element2) {

        return element1.equals(element2);

    }

    public static void main(String[] args) {

        // Integer objects
        Integer i1 = 626, i2 = 262, i3 = 626;

        // checking if i1 and i2 are equal
        System.out.println(i1 + " equals " + i2 + "? " + equalsBlack(i1, i2)); // false

        // checking if i1 and i3 are equal
        System.out.println(i1 + " equals " + i3 + "? " + equalsBlack(i1, i3)); // true

        // Strings and testing method
        String s1 = "Black", s2 = "black", s3 = "Black";

        System.out.println(s1 + " equals " + s2 + "? " + equalsBlack(s1, s2)); // false

        System.out.println(s1 + " equals " + s3 + "? " + equalsBlack(s1, s3)); // true


    }

}
