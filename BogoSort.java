/* BogoSort algorithm that uses an
arrayList and the createGraph class
to showcase the algorithm
 */

import java.util.ArrayList;

public class BogoSort {
    private String runTime = "O(???)";
    private int rank = 6;
    private ArrayList<Integer> values;
    private CreateGraph graph;
    public BogoSort(ArrayList<Integer> values, CreateGraph graph){
        this.values = values;
        this.graph = graph;
    }


    // BogoSort algorithm initiated
    public void doBogoSort() {
        while (!isSorted(values)) {
            shuffle(values);
            graph.setValues(values);
            graph.paintImmediately(0,0,1500,600);
        }
    }

    // is it sorted?
    private boolean isSorted(ArrayList<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    // random positions in the array
    private void shuffle(ArrayList<Integer> list) {
        int n = list.size();
        for (int i = n - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }


    // BubbleSort instant algorithm initiated
    public void doInstantBogoSort(){
        while (!isSorted(values)) {
            shuffle(values);
        }
    }
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


