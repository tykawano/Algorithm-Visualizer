/* Cocktail shaker sort
algorithm that uses an
arrayList and the createGraph class
to showcase the algorithm
 */

import java.util.ArrayList;

public class CocktailShakerSort {
    private String runTime = "O(n^2)";
    private int rank = 5;
    private ArrayList<Integer> values;
    private CreateGraph graph;
    public CocktailShakerSort(ArrayList<Integer> values, CreateGraph graph){
        this.values = values;
        this.graph = graph;
    }


    // Cocktail shaker sort algorithm initiated
    public void doCocktailShakerSort() {
        int temp;
        int left = 0;
        int right = values.size() - 1;
        boolean swapped;

        do {
            swapped = false;

            // Traverse from left to right, pushing the largest element to the end
            for (int i = left; i < right; i++) {
                if (values.get(i) > values.get(i + 1)) {
                    temp = values.get(i);
                    values.set(i, values.get(i + 1));
                    values.set(i + 1, temp);
                    swapped = true;
                    graph.setValues(values);
                    graph.setIndexHighlight(i);
                    graph.paintImmediately(0,0,1500,600);
                }
            }

            if (!swapped) {
                // If no swaps occurred, the array is sorted
                break;
            }

            // Move the right pointer one step back (excluding the largest element)
            right--;

            swapped = false;

            // Traverse from right to left, pushing the smallest element to the beginning
            for (int i = right; i > left; i--) {
                if (values.get(i) < values.get(i - 1)) {
                    temp = values.get(i);
                    values.set(i, values.get(i - 1));
                    values.set(i - 1, temp);
                    swapped = true;
                    graph.setValues(values);
                    graph.setIndexHighlight(i);
                    graph.paintImmediately(0,0,1500,600);
                }
            }

            // Move the left pointer one step forward (excluding the smallest element)
            left++;
        } while (swapped);

    }


    // BubbleSort instant algorithm initiated
    public void doInstantCocktailShakerSort(){
        int temp;
        int left = 0;
        int right = values.size() - 1;
        boolean swapped;

        do {
            swapped = false;

            // Traverse from left to right, pushing the largest element to the end
            for (int i = left; i < right; i++) {
                if (values.get(i) > values.get(i + 1)) {
                    temp = values.get(i);
                    values.set(i, values.get(i + 1));
                    values.set(i + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) {
                // If no swaps occurred, the array is sorted
                break;
            }

            // Move the right pointer one step back (excluding the largest element)
            right--;

            swapped = false;

            // Traverse from right to left, pushing the smallest element to the beginning
            for (int i = right; i > left; i--) {
                if (values.get(i) < values.get(i - 1)) {
                    temp = values.get(i);
                    values.set(i, values.get(i - 1));
                    values.set(i - 1, temp);
                    swapped = true;
                }
            }

            // Move the left pointer one step forward (excluding the smallest element)
            left++;
        } while (swapped);

    }

    //final animation
    public void postAnimation() {
        graph.setStatusDone(true);
        graph.setValues(values);
        for (int i = 0; i < values.size(); i++) {
            graph.setIndexHighlight(i);
            graph.paintImmediately(0,0,1500,600);
        }
        graph.setPostDone(true);
        for (int i = values.size() - 1; i >= 0; i--) {
            graph.setIndexHighlight(i);
            graph.paintImmediately(0,0,1500,600);
        }
        graph.setIndexHighlight(-1);
    }


    public String getRunTime() {
        return runTime;
    }


    public int getRank() {
        return rank;
    }
}


