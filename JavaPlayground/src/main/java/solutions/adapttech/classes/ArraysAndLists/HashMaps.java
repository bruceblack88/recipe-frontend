package solutions.adapttech.classes.ArraysAndLists;

import java.util.HashMap;

public class HashMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> fruitCount = new HashMap<>();

        //add items to hash map
        fruitCount.put("Bananas", 5);
        fruitCount.put("Apples", 3);
        fruitCount.put("Grapes", 25);

        //output by key
        System.out.println("specific value by key " + fruitCount.get("Bananas"));



    }

}
