package solutions.adapttech.classes.javaMasterClass;

import java.util.ArrayList;

public class SumOddRange {
    public static boolean isOdd(int number) {
        if (number < 0) {
            return false;
        } else if (number % 2 != 0) {
            return true;
        }
        return false;
    }

    public static int sumOdd(int start, int end) {
        int sum = 0;
        ArrayList<Integer> rangeList = new ArrayList<>();
        if (end <= start || start == 0 || end == 0) {
            return -1;
        } else {
            for (int i = 0; i < end; i++) {
                rangeList.add(i);
                for (int j = 0; j < rangeList.size(); j++) {
                    if (rangeList.indexOf(j) % 2 != 0) {
                        (j)++;
                        sum = rangeList.size();
                        return sum;
                    } else {
                        return -1;
                    }
                }
            }
        }
        return sum;
    }

}
