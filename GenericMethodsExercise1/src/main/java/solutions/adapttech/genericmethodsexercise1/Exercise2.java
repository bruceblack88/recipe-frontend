/*
Bruce Black
CSIS 505
Software Development
Generic Methods and Classes Exercise 2
June 20, 2021
 */
package solutions.adapttech.genericmethodsexercise1;

import java.util.ArrayList;

public class Exercise2 {

    public static void main(String[] args) {

        // ArrayList of 10 Pair objects
        ArrayList<Pair<Integer, Double>> pairList = new ArrayList<Pair<Integer, Double>>();

        // looping from i=1 to 10
        for (int i = 1; i <= 10; i++) {

            // creating a Pair with first=i and second = square root of i,
            // adding the pair to the list
            pairList.add(new Pair<Integer, Double>(i, Math.sqrt(i)));

        }

        //looping and displaying each pair
        for (Pair<Integer, Double> pair : pairList) {

            System.out.println(pair);

        }

    }

}
