import java.util.ArrayList;

public class Task1_BubbleSort_NonOptimised {
    public static void main(String[] args) {
        /* Full Array */
        ArrayList<Wine> wines = ReadFromFile.readFile();
        /* Array only with alcoholValues */
        ArrayList<Double> alcoholValues = new ArrayList<>();

        for(Wine wine : wines){
            if(!alcoholValues.contains(wine.alcohol())) {
                alcoholValues.add(wine.alcohol());
            }
        }

        bubbleSort(alcoholValues);
    }

    public static void bubbleSort(ArrayList <Double> alcoholValues){
        /* TODO: Bubble Sort Non-Optimised */
        System.out.println(alcoholValues);
    }
}
