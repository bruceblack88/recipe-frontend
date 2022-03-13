/*
Bruce Black
CSIS 505
Software Development
GENERIC COLLECTIONS, LAMBDAS, AND STREAMS ASSIGNMENT 
July 4, 2021
 */
package solutions.adapttech.genericcollectionsexercise1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListSearch {

    public static <T> T search(List<T> list, T value, int index) {

        if (list == null || index == list.size()) {
            return null;
        }

        if (value.equals(list.get(index))) {
            return list.get(index);
        }

        return search(list, value, index + 1);

    }

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        System.out.println("Enter integers(-1 to stop): ");

        int num;

        Scanner sc = new Scanner(System.in);

        while (true) {

            num = sc.nextInt();

            if (num == -1) {
                break;
            }

            list.add(num);

        }

        System.out.print("Enter integer to search: ");

        int key = sc.nextInt();

        Integer res = search(list, key, 0);

        if (res == null) {
            System.out.println(key + " is not in list");
        } else {
            System.out.println(key + " is available in list");
        }

    }

}
