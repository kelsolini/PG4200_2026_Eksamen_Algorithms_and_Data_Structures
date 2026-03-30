import java.util.ArrayList;

public class Task1_BubbleSort_NonOptimised {
    public static void main(String[] args) {
        /* Full Array */
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
        System.out.println(alcoholValues);
        int[] result = bubbleSort(alcoholValues);
        System.out.println("After sorting:");
        System.out.println(alcoholValues);
        System.out.println("Iterations: " + result[0]);
        System.out.println("Swaps: " + result[1]);
    }

    public static int[] bubbleSort(ArrayList<Double> list) {
        int iteration = 0;
        int swap = 0;

        // Outer loop - will run exactly n-1 times
        for (int i = 0; i < list.size() - 1; i++) {
            iteration++;
            // Inner loop - compares and swaps adjacent elements if needed
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    double temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    swap++;
                }
            }
        }
        // Returns number of passes and swaps for analysis
        return new int[]{iteration, swap};
    }
}
