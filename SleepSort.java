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

        for (int num : values) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(num);
                    System.out.println(num);
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
}
