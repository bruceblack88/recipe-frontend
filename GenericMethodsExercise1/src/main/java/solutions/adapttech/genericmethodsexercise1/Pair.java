/*
Bruce Black
CSIS 505
Software Development
Generic Methods and Classes Exercise 2
June 20, 2021
 */
package solutions.adapttech.genericmethodsexercise1;

public class Pair<F, S> {

    //attributes
    private F first;

    private S second;

    //constructor
    public Pair(F first, S second) {

        this.first = first;

        this.second = second;

    }

    //get and set
    public F getFirst() {

        return first;

    }

    public S getSecond() {

        return second;

    }

    public void setFirst(F first) {

        this.first = first;

    }

    public void setSecond(S second) {

        this.second = second;

    }

    //returns a String in format (f, s)
    @Override

    public String toString() {

        return "(" + first + ", " + second + ")";

    }

}
