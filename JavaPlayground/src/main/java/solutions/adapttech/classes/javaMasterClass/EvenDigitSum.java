package solutions.adapttech.classes.javaMasterClass;

public class EvenDigitSum {
    public static int getEvenDigitSum(int number){

        int sum = 0;
        if(number < 0){
            return -1;
        } else{
            String numberString = String.valueOf(number);
            char[] digits = numberString.toCharArray();
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] % 2== 0){
                    sum +=i;
                }

            }

        }
        return sum;
    }
}
