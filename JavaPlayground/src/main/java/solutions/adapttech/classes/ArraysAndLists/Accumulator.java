package solutions.adapttech.classes.ArraysAndLists;


import java.util.HashMap;
import java.util.List;

public class Accumulator {
    //SumOfPositiveValues

//    [1,2,3,4]
//    10

//    [1,2,-2,100,-5]
//    103

//  []
//    0

//    [-3,0,-3]
//    0
//    public static int sumOfPositiveValues(int[] nums) {
//        //define accumulator
//        int sum = 0;
//        //iterate through the array provided
//        for (int i = 0; i < nums.length; i++) {
//
//            //we want to add positive numbers to the sum
//            if(nums[i] > 0){
//                sum += nums[i];
//            }
//
//        }
//        return sum;
//
//    }
    //test

// CharacterCount

    //"aaabbc"
    //HashMap
//    "a" : 3,
//    "b" : 2,
//    "c" : 1

    //"bananas"
//    hashmap
//    "b" : 1,
//    "a" : 3,
//    "n" : 2,
//    "s" : 1

    public static HashMap<String, Integer> characterCount(String characters){
        //define accumulator
        HashMap<String, Integer> characterMap = new HashMap<>();

        for (int i = 0; i < characters.length(); i++) {

            //converts char to string
            String currentLetter = String.valueOf(characters.charAt(i));

            //check to see if the letter exists in hashmap
            if(characterMap.containsValue(currentLetter)){
                //if it does exist, add one to value
                characterMap.put(currentLetter, characterMap.get(currentLetter) + 1);

            } else {

                //if it does not exist, add it to the hashmap with the value as one
                characterMap.put(currentLetter, 1);
            }

        }
        //return accumulator
        return characterMap;
    }
    public static void main(String[] args) {
//        int[] numberArray = new int[]{-3,0,-3};
//        System.out.println(sumOfPositiveValues(numberArray));
        System.out.println(characterCount("bananas"));
    }

}
