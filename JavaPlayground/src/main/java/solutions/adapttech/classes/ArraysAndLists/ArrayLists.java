package solutions.adapttech.classes.ArraysAndLists;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayLists<S> {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        //prints size of array
        System.out.println("size of array " + numbers.size());

        //add items to array list
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        //get index
        numbers.get(1);
        System.out.println("index [1] " + numbers.get(1));
        System.out.println("prints elements of array list" + numbers);
        System.out.println("size of array " + numbers.size());

        //lists each element
        for (int i = 0; i < numbers.size(); i++){
            System.out.println("element " + numbers.get(i));
        }
        //turn arrays into a list ie to use if you need to sort an existing array
        String[] fruits = new String[]{"apple", "orange", "banana"};

        ArrayList<String> fruitsArrayList = new ArrayList<>(Arrays.asList(fruits));
        

        ArrayList<Integer> integerArrayList = new ArrayList<>(Arrays.asList(1,2,3,4));
    }
}
