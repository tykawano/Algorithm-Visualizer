/* SelectionSort algorithm that uses an
arrayList and the createGraph class
to showcase the algorithm
 */

import java.util.ArrayList;

public class SelectionSort {
    private String runTime = "O(n^2)";
    private int rank = 2;
    private ArrayList<Integer> values;
    private CreateGraph graph;
    public SelectionSort(ArrayList<Integer> values, CreateGraph graph){
        this.graph = graph;
        this.values = values;
    }

    // Selection algorithm initiated
    public void doSelectionSort(){
        int length = values.size();

        for(int i = 0;i < length;i++){
            int minIndex = i;
            for(int j = i + 1;j < length;j++){
                if(values.get(j) < values.get(minIndex)){
                    minIndex = j;
                    graph.setValues(values);
                    graph.setIndexHighlight(j);
                    graph.paintImmediately(0,0,1500,600);
                }
            }
            int temp = values.get(minIndex);
            values.set(minIndex, values.get(i));
            values.set(i, temp);
            graph.setValues(values);
            graph.setIndexHighlight(i);
            graph.paintImmediately(0,0,1500,600);
        }
    }

    // Selection instant algorithm initiated
    public void doInstantSelctionSort(){
        int length = values.size();

        for(int i = 0;i < length;i++){
            int minIndex = i;
            for(int j = i + 1;j < length;j++){
                if(values.get(j) < values.get(minIndex)){
                    minIndex = j;
                }
            }
            int temp = values.get(minIndex);
            values.set(minIndex, values.get(i));
            values.set(i, temp);
        }
    }


    // final process
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
