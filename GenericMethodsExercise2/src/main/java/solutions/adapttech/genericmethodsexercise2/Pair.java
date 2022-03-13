/*
Bruce Black
CSIS 505
Software Development
Generic Methods and Classes Exercise 2
June 20, 2021
 */
package solutions.adapttech.genericmethodsexercise2;

public class Pair<F, S> {
    // attributes

    private F first;

    private S second;

    // get and set
    public F getFirst() {
        return first;
    }

    public void setFirst(F first) {
        this.first = first;
    }

    public S getSecond() {
        return second;
    }

    public void setSecond(S second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair [first=" + first + ", second=" + second + "]";
    }

}
