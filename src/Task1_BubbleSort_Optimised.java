import java.util.ArrayList;

public class Task1_BubbleSort_Optimised {
    public static void main(String[] args) {

        /* Original array */
        ArrayList<Wine> wines = ReadFromFile.readFile();

        /* Array only with alcoholValues */
        ArrayList<Double> alcoholValues = new ArrayList<>();

        /* Looping through original Array and making new one with only alcoholValues */
        for(Wine wine : wines){
            if(!alcoholValues.contains(wine.alcohol())) {
                alcoholValues.add(wine.alcohol());
            }
        }
        System.out.println("Before sorting:");
        System.out.println(new ArrayList<>(alcoholValues));
        int[] result = bubbleSort(alcoholValues);
        System.out.println("After sorting:");
        System.out.println(alcoholValues);
        System.out.println("Iterations: " + result[0]);
        System.out.println("Swaps: " + result[1]);

    }

     /**
     SOURCE FOR BUBBLE SORT
     Title   : Bubble Sort Algorithm
     Author  : Geeks for Geeks
     Date    : January 21, 2025
     URL     : https://www.geeksforgeeks.org/bubble-sort-algorithm/
     Accessed: 2025-04-23
     Note    : Adapted to sort unique alcohol values from the data.Wine Quality dataset
     **/

    // Optimized: stops early if no swaps occurred in a pass
    public static int[] bubbleSort(ArrayList<Double> list) {
        int iteration = 0;
        int swap = 0;

        // Outer loop - will run max n-1 times
        for (int i = 0; i < list.size() - 1; i++) {
            iteration++;
            boolean swapped = false;

            // Inner loop - compares and swaps adjacent elements if needed
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    double temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swap++;
                    swapped = true;
                }
            }
            // If no elements were swapped this pass, the list is already sorted
            if (!swapped) break;
        }
        // Returns number of passes and swaps for analysis
        return new int[]{iteration, swap};
    }
}
