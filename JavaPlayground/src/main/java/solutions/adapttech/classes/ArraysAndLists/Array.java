package solutions.adapttech.classes.ArraysAndLists;


public class Array {
    public static void main(String[] args) {
        //create array with values manually
        int[] nums = new int[]{1,2,3,4};
        //create array by space
        //int[] nums = new int[4];

        //changes element
        nums[0] = 1;
        nums[1] = 10;

        //prints memory address
        System.out.println("memory address " + nums);

        //prints index
        System.out.println("prints index [1] " + nums[1]);

        //prints entire array
        for (int i = 0; i < nums.length; i++) {
            System.out.println("prints entire array " + nums[i]);
        }

    }
}
