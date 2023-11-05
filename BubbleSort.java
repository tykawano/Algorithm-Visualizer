/* BubbleSort algorithm that uses an
arrayList and the createGraph class
to showcase the algorithm
 */

import java.util.ArrayList;

public class BubbleSort {
    private String runTime = "O(n^2)";
    private int rank = 3;
    private ArrayList<Integer> values;
    private CreateGraph graph;
    public BubbleSort(ArrayList<Integer> values, CreateGraph graph){
        this.values = values;
        this.graph = graph;
    }


    // BubbleSort algorithm initiated
    public void doBubbleSort() {
        int temp;
        for (int i = 0; i < values.size() - 1; i++) {
            for (int j = 0; j < values.size() - i - 1 ; j++) {
                if(values.get(j) > values.get(j + 1)){
                    temp = values.get(j);
                    values.set(j, values.get(j+1));
                    values.set(j+1, temp);
                    graph.setValues(values);
                    graph.setIndexHighlight(j + 1);
                    graph.paintImmediately(0,0,1500,600);
                }
            }
        }
    }


    // BubbleSort instant algorithm initiated
    public void doInstantBubbleSort(){
        int temp;
        for (int i = 0; i < values.size() - 1; i++) {
            for (int j = 0; j < values.size() - i - 1 ; j++) {
                if(values.get(j) > values.get(j + 1)){
                    temp = values.get(j);
                    values.set(j, values.get(j+1));
                    values.set(j+1, temp);
                }
            }
        }
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

