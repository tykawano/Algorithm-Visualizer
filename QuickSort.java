/* QuickSort algorithm that uses an
arrayList and the createGraph class
to showcase the algorithm
 */

import java.util.ArrayList;

public class QuickSort {
    private String runTime = "O(log n)";
    private int rank = 1;
    private ArrayList<Integer> values;
    private CreateGraph graph;
    public QuickSort(ArrayList<Integer> values, CreateGraph graph){
        this.graph = graph;
        this.values = values;
    }


    // QuickSort algorithm initiated
    public void doQuickSort(){
        recursiveQuickSort(values, 0, values.size() - 1);
    }


    // Recursive sort
    private void recursiveQuickSort(ArrayList<Integer> values, int start,int end ){
        if(end <= start){
            return;
        }
        int pivot = partition(values, start, end);
        recursiveQuickSort(values, start, pivot - 1);
        recursiveQuickSort(values, pivot + 1, end);
    }


    // Recursive sort
    private int partition(ArrayList<Integer> values, int start,int end ) {
        int pivot = values.get(end);
        int i = start - 1;
        for(int j = start;j <= end - 1;j++){
            if(values.get(j) < pivot){
                i++;
                int temp = values.get(i);
                values.set(i,values.get(j));
                values.set(j, temp);
                graph.setValues(values);
                graph.setIndexHighlight(j);
                graph.paintImmediately(0,0,1500,600);
            }
        }
        i++;
        int temp = values.get(i);
        values.set(i,values.get(end));
        values.set(end, temp);
        graph.setValues(values);
        graph.setIndexHighlight(i);
        graph.paintImmediately(0,0,1500,600);
        return i;
    }


    // QuickSort instant algorithm initiated
    public void doInstantQuicksort(){
        instantRecQuicksort(values,0,values.size() - 1);
    }


    // Recursive sort
    private void instantRecQuicksort(ArrayList<Integer> values, int start,int end ){
        if(end <= start){
            return;
        }
        if (end <= start) {
            return;
        }
        int pivot = instantPartition(values, start, end);
        instantRecQuicksort(values, start, pivot - 1);
        instantRecQuicksort(values, pivot + 1, end);
    }


    // Recursive sort
    private int instantPartition(ArrayList<Integer> values, int start, int end){
        int pivot = values.get(end);
        int i = start - 1;
        for(int j = start;j <= end - 1;j++){
            if(values.get(j) < pivot){
                i++;
                int temp = values.get(i);
                values.set(i,values.get(j));
                values.set(j, temp);
            }
        }
        i++;
        int temp = values.get(i);
        values.set(i,values.get(end));
        values.set(end, temp);
        return i;
    }


    // last animation
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
