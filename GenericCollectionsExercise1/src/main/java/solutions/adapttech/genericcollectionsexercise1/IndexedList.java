/*
Bruce Black
CSIS 505
Software Development
GENERIC COLLECTIONS, LAMBDAS, AND STREAMS ASSIGNMENT 
July 4, 2021
 */
package solutions.adapttech.genericcollectionsexercise1;

import java.util.ArrayList;

public class IndexedList {

    public static void main(String args[]) {
        ArrayList<String> obj = new ArrayList<String>();
        obj.add("Brucey");
        obj.add("Goosey");
        obj.add("Black");
        obj.add("Love");
        obj.add("Lovely");
       
        System.out.println("Currently the array list has following elements:" + obj);
        obj.add(0, "Bruce");
        obj.add(1, "Harry");
        obj.remove("Lovely");
        obj.remove("Harry");
        System.out.println("Current array list is:" + obj);
        obj.remove(1);
        System.out.println("Current array list is:" + obj);
    }
}
