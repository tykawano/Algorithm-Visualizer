/*
 * Written by Boyd Pelley
 * February 13, 2024
 *
 * This algorithm was found to be one of the fastest sorting algorithms in CERTAIN applications, this sorting method
 * creates threads for each item to be sorted - each thread 'sleeping' for a certain amount of time until the array is
 * sorted.
 * The time complexity of this sorting method can be as fast as O(n log(n)) all the way to O(n^2), depending on the
 * values being sorted.
 */

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.zip.CRC32;

public class SleepSort {
    private String runTime = "O(n log(n)) -> O(n^2)";
    private int rank = 3;
    private ArrayList<Integer> values;
    private CreateGraph graph;
    public SleepSort(ArrayList<Integer> values, CreateGraph graph) {
        this.values = values;
        this.graph = graph;
    }

    // SleepSort algorithm initiated
    public void doSleepSort() {
        ArrayList<Thread> threads = new ArrayList<>();

        for (int i = 0; i < values.size(); i++) {
            final int index = i;
            Thread thread = new Thread(() -> {
                try {
                    int sleepDuration = values.get(index);
                    Thread.sleep(sleepDuration);

                    // Modify the values array within a synchronized block
                    synchronized (values) {
                        // Find the correct position to insert the value
                        int insertIndex = 0;
                        while (insertIndex < values.size() && values.get(insertIndex) < sleepDuration) {
                            insertIndex++;
                        }

                        // Insert the value at the correct position
                        values.add(insertIndex, sleepDuration);
                        values.remove(index + 1); // Remove the old occurrence

                        // Update the UI or any other logic
                        graph.setValues(values);
                        graph.setIndexHighlight(insertIndex);
                        graph.paintImmediately(0, 0, 1500, 600);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (!isSorted(values)) doSleepSort();
    }

    public boolean isSorted(ArrayList<Integer> vals) {
        for (int i = 0; i < vals.size() - 1; i++) {
            if (vals.get(i) > vals.get(i + 1)) return false;
        }
        return true;
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
