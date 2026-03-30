import java.util.ArrayList;

public class Task3_MergeSort {
    public static void main(String[] args) {
        /* Original Array */
        ArrayList<Wine> wines = ReadFromFile.readFile();

        /* Array only with alcoholValues */
        ArrayList<Double> alcoholValues = new ArrayList<>();

        /* Looping through original Array and making new one with only alcoholValues */
        for(Wine wine : wines){
            if(!alcoholValues.contains(wine.alcohol())) {
                alcoholValues.add(wine.alcohol());
            }
        }
        mergeSort(alcoholValues);

        System.out.println("Sorted alcohol values:");
        for (Double value : alcoholValues) {
            System.out.println(value);
        }

        System.out.println("\nTotal merge operations: " + mergeCount);

    }

    /**************************************************************************************
     *   SOURCE FOR MERGE SORT
     *   Title   : Writing a Merge Sort in Pseudocode (Guide)
     *   Author  : PseudoEditor.com
     *   Date    : n.d.
     *   URL     : https://pseudoeditor.com/guides/merge-sort
     *   Accessed: 2025-03-29
     *   Note    : Adapted to sort unique alcohol values from the Wine Quality dataset
     **************************************************************************************/

    // Tracks total number of merge operations performed
    public static int mergeCount = 0;

    // Recursively splits the list in half and merges the sorted halves back together
    public static void mergeSort(ArrayList<Double> list) {
        // Base case: a list of 0 or 1 element is already sorted
        if (list.size() <= 1) return;

        int mid = list.size() / 2;

        // Split into left and right halves
        ArrayList<Double> left  = new ArrayList<>(list.subList(0, mid));
        ArrayList<Double> right = new ArrayList<>(list.subList(mid, list.size()));

        // Recursively sort each half
        mergeSort(left);
        mergeSort(right);

        // Merge the two sorted halves back into the original list
        merge(list, left, right);
    }

    private static void merge(ArrayList<Double> dest, ArrayList<Double> left, ArrayList<Double> right) {
        mergeCount++; // Count every merge operation

        int li = 0; // pointer into left
        int ri = 0; // pointer into right
        int di = 0; // pointer into destination

        // Compare elements from both halves and place the smaller one first
        while (li < left.size() && ri < right.size()) {
            if (left.get(li) <= right.get(ri)) {
                dest.set(di, left.get(li));
                li++;
            } else {
                dest.set(di, right.get(ri));
                ri++;
            }
            di++;
        }

        // Copy any remaining elements from the left half
        while (li < left.size()) {
            dest.set(di, left.get(li));
            li++;
            di++;
        }

        // Copy any remaining elements from the right half
        while (ri < right.size()) {
            dest.set(di, right.get(ri));
            ri++;
            di++;
        }
    }

}
