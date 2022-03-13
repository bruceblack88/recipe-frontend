/*
Bruce Black
CSIS 505
Software Development
Generic Methods and Classes Exercise 2
June 20, 2021
 */
package solutions.adapttech.genericmethodsexercise2;

import java.util.ArrayList;
import java.util.List;

public class Exercise2 {

	public static void main(String[] args) {
		List<Pair> pairs = new ArrayList<Pair>();
		
		Pair<String,String> pair1 = new Pair<String, String>();
		pair1.setFirst("First");
		pair1.setSecond("Second");
		

		Pair<String,String> pair2 = new Pair<String, String>();
		pair2.setFirst("Pair 2 first");
		pair2.setSecond("Pair 2 second");
		
		Pair<String,String> pair3 = new Pair<String, String>();
		pair3.setFirst("Pair 3 first");
		pair3.setSecond("Pair 3 second");
		
		Pair<Integer,Integer> pair4 = new Pair<Integer, Integer>();
		pair4.setFirst(41);
		pair4.setSecond(42);
		
		Pair<String,String> pair5 = new Pair<String, String>();
		pair5.setFirst("Pair 5 first");
		pair5.setSecond("Pair 5 second");
		
		Pair<String,String> pair6 = new Pair<String, String>();
		pair6.setFirst("Pair 6 first");
		pair6.setSecond("Pair 6 second");
		
		Pair<String,String> pair7 = new Pair<String, String>();
		pair7.setFirst("Pair 7 first");
		pair7.setSecond("Pair 7 second");
		
		Pair<String,String> pair8 = new Pair<String, String>();
		pair8.setFirst("Pair 8 first");
		pair8.setSecond("Pair 8 second");
		
		Pair<String,Integer> pair9 = new Pair<String, Integer>();
		pair9.setFirst("Pair 9 first");
		pair9.setSecond(92);
		
		Pair<String,Integer> pair10 = new Pair<String, Integer>();
		pair10.setFirst("Pair 10 first");
		pair10.setSecond(102);
		
		pairs.add(pair1);
		pairs.add(pair2);
		pairs.add(pair3);
		pairs.add(pair4);
		pairs.add(pair5);
		pairs.add(pair6);
		pairs.add(pair7);
		pairs.add(pair8);
		pairs.add(pair9);
		pairs.add(pair10);
		
		for(Pair p : pairs) {
			System.out.println(p.toString());
		}
		
	}

}
