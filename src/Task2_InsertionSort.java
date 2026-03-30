import java.util.ArrayList;
import java.util.Collections;

public class Task2_InsertionSort {
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
        /* Calling the insertion sorting function and sending the Array with alcohol values only */
        insertionSort(alcoholValues);

        System.out.println("Random sorted array ->");
        randomArrangeArray(alcoholValues);

        System.out.println("Sort sorted array ->");
        insertionSort(alcoholValues);
    }

    public static void insertionSort(ArrayList<Double> list) {
        System.out.println("Before sorting: " + list);

        int n = list.size();
        for (int i = 1; i < n; i++) {
            double key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
        System.out.println("After sorting: " + list);
    }

    public static void randomArrangeArray(ArrayList<Double> list) {
        Collections.shuffle(list);
        System.out.println(list);
    }
}
