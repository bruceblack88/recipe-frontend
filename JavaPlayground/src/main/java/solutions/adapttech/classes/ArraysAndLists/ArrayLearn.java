package solutions.adapttech.classes.ArraysAndLists;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayLearn {
    public static void main(String[] args) {
        // Implement the sortArray method below below

            String[] inputArray = new String[]{"as", "cd" , "bs"};

            ArrayList<String> sortArray = new ArrayList<>(Arrays.asList(inputArray));
            sortArray.sort(null);
        System.out.println(sortArray);

    }
}
