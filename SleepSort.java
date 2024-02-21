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
    private int rank = -1;
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
                        // Move the value to the beginning of the array
                        values.remove(index);
                        values.add(0, sleepDuration);

                        // Update the UI or any other logic
                        graph.setValues(values);
                        graph.setIndexHighlight(0);
                        graph.paintImmediately(0, 0, 1500, 600);
                        System.out.print(sleepDuration + " ");
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
