/*Insertion algorithm that uses an
arrayList and the createGraph class
to showcase the algorithm
 */

import java.util.ArrayList;

public class InsertionSort {
    private String runTime = "O(n^2)";
    private int rank = 6;
    private ArrayList<Integer> values;
    private CreateGraph graph;
    public InsertionSort(ArrayList<Integer> values, CreateGraph graph){
        this.values = values;
        this.graph = graph;
    }


    // BubbleSort algorithm initiated
    public void doInsertionSort() {
        for (int i = 1; i < values.size(); i++) {
            int temp = values.get(i);
            int j = i - 1;

            while(j >= 0 && values.get(j) > temp){
                values.set(j + 1, values.get(j));
                j--;
                graph.setValues(values);
                graph.setIndexHighlight(j + 1);
                graph.paintImmediately(0, 0, 1500, 600);
            }
            values.set(j + 1, temp);

            graph.setValues(values);
            graph.setIndexHighlight(i);
            graph.paintImmediately(0, 0, 1500, 600);
        }

    }


    // BubbleSort instant algorithm initiated
    public void doInstantInsertionSort(){
        for (int i = 1; i < values.size(); i++) {
            int temp = values.get(i);
            int j = i - 1;

            while(j >= 0 && values.get(j) > temp){
                values.set(j + 1, values.get(j));
                j--;
            }
            values.set(j + 1, temp);
        }
    }

    // final animation
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

