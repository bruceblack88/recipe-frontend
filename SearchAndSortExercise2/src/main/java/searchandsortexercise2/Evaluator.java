/*
Bruce Black
CSIS 505
Software Development
June 13, 2021
 */
package searchandsortexercise2;

import java.util.Random;

public class Evaluator {

    static Random r = new Random();

    public static void main(String args[]) {

        System.out.println("Sort\t\t best case\t\t average case\t\t worst case");
        SelectionSortBlack();
        InsertionSortBlack();
        MergeSortBlack();
    }
    // selection sort
    public static void SelectionSortBlack() {
        long starttime;
        long endtime;

        starttime = System.nanoTime();
        selectionSort(getSequentialArray());
        endtime = System.nanoTime();
        long best = endtime - starttime;

        starttime = System.nanoTime();
        selectionSort(getRandomArray());
        endtime = System.nanoTime();
        long average = endtime - starttime;

        starttime = System.nanoTime();
        selectionSort(getDescendingArray());
        endtime = System.nanoTime();
        long worst = endtime - starttime;

        System.out.println(String.format("Selection sort\t\t%d\t\t%d\t\t%d", best, average, worst));

    }
    // insertion sort
    public static void InsertionSortBlack() {
        long starttime;
        long endtime;

        starttime = System.nanoTime();
        insertionSort(getSequentialArray());
        endtime = System.nanoTime();
        long best = endtime - starttime;

        starttime = System.nanoTime();
        insertionSort(getRandomArray());
        endtime = System.nanoTime();
        long average = endtime - starttime;

        starttime = System.nanoTime();
        insertionSort(getDescendingArray());
        endtime = System.nanoTime();
        long worst = endtime - starttime;

        System.out.println(String.format("Insertion sort\t\t%d\t\t%d\t\t%d", best, average, worst));
    }
    // merge sort
    public static void MergeSortBlack() {
        long starttime;
        long endtime;

        starttime = System.nanoTime();
        MergeSort(getSequentialArray());
        endtime = System.nanoTime();
        long best = endtime - starttime;

        starttime = System.nanoTime();
        MergeSort(getRandomArray());
        endtime = System.nanoTime();
        long average = endtime - starttime;

        starttime = System.nanoTime();
        MergeSort(getDescendingArray());
        endtime = System.nanoTime();
        long worst = endtime - starttime;

        System.out.println(String.format("Merge sort\t\t%d\t\t%d\t\t%d", best, average, worst));
    }
    /*// Returns an array with 100,000 int values in sequential order, starting with 1 and ending with 100,000.
    public static int[] getSequentialArray() {
        int[] a = new int[100000];

        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }

        return a;
    }
    // Returns an array with 100,000 random int values.
    public static int[] getRandomArray() {
        int[] a = new int[100000];

        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(100000 + 1 - 1) + 1;

        }

        return a;
    }
    // Returns an array with 100,000 int values in descending sequential order, starting with 100,000 and ending with 1. 
    public static int[] getDescendingArray() {
        int[] a = new int[100000];

        int j = 100000;
        for (int i = 0; i < a.length; i++) {
            a[i] = j;
            j--;

        }

        return a;
    }*/
    // Returns an array with 1,000 int values in sequential order, starting with 1 and ending with 1,000.
    public static int[] getSequentialArray() {
        int[] a = new int[1000];

        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }

        return a;
    }
    // Returns an array with 1,000 random int values.
    public static int[] getRandomArray() {
        int[] a = new int[1000];

        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(1000 + 1 - 1) + 1;

        }

        return a;
    }
    // Returns an array with 1,000 int values in descending sequential order, starting with 1,000 and ending with 1. 
    public static int[] getDescendingArray() {
        int[] a = new int[1000];

        int j = 1000;
        for (int i = 0; i < a.length; i++) {
            a[i] = j;
            j--;

        }

        return a;
    }

    public static void insertionSort(int[] data) {
          
        for (int next = 1; next < data.length; next++) {
            int insert = data[next]; 
            int moveItem = next; 

            
            while (moveItem > 0 && data[moveItem - 1] > insert) {
           
                data[moveItem] = data[moveItem - 1];
                moveItem--;
            }

            data[moveItem] = insert; 
        }

    }

    public static void selectionSort(int[] data) {
      
        for (int i = 0; i < data.length - 1; i++) {
            int smallest = i; 

          
            for (int index = i + 1; index < data.length; index++) {
                if (data[index] < data[smallest]) {
                    smallest = index;
                }
            }

            swap(data, i, smallest); 
        }
    } 

    private static void swap(int[] data, int first, int second) {
        int temporary = data[first]; 
        data[first] = data[second]; 
        data[second] = temporary; 
    }

    private static int[] numbers;
    private static int[] helper;

    private static int number;

    public static void MergeSort(int[] values) {
        numbers = values;
        number = values.length;
        helper = new int[number];
        mergesort(0, number - 1);
    }

    private static void mergesort(int low, int high) {

        if (low < high) {

            int middle = low + (high - low) / 2;

            mergesort(low, middle);

            mergesort(middle + 1, high);

            merge(low, middle, high);
        }
    }

    private static void merge(int low, int middle, int high) {


        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }

    }

}
