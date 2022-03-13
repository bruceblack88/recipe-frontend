package solutions.adapttech.classes.ArraysAndLists;

    /*In the space below, define and implement a method called toSentence. It takes as input an array of strings
(String[]) and returns a string that contains all the elements of the array joined by a comma, with the last
element joined by "and".

//      1. Determine Inputs and Outputs

        Input [""] should return ""
        Input [] should return ""
        Input ["Alice", "Bob"] should return "Alice and Bob"
        Input ["Alice", "Bob", "Carol"] should return "Alice, Bob and Carol"
*/

public class SolvingAnAccumulatorProblem {
    public static String toSentence(String[] nameInput){
        String sentence = "";
//        if only one name return name as string
        if (nameInput.length == 1){
            return  nameInput[0];
        }

        for (int i = 0; i < nameInput.length; i++) {
//            if not on 2nd to last word add a name and a comma and a space

//            if on 2nd to last word add condition and space
//            if on last word add name

            if(nameInput.length -1 == i){
                sentence = sentence + " "+ nameInput[i];
            } else if (nameInput.length -2 == i){
                sentence = sentence + nameInput[i] + " and";

            } else {
                sentence = sentence + nameInput[i] + ", ";
            }


        }

        return sentence;
    }

    public static void main(String[] args) {

        String[] nameSentence = new String[] {"Alice", "Bryan", "Charles", "Do", "Echo"};

        System.out.println(toSentence(nameSentence));

    }

}
