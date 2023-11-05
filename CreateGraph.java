/* Animates the graph for each algorithm, creates
a bar graph and a red highlighter indicator bar,
and a post-animation
 */

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
public class CreateGraph extends JPanel{
    private final int HEIGHT_Y = 600;
    private final int WIDTH_X = 1500;
    private ArrayList<Integer> values;
    private int indexHighlight = -1;
    private boolean statusDone = false;
    private boolean postDone = false;
    private int trackLastXpos = 0;
    public CreateGraph(ArrayList<Integer> values){
        this.values = values;
        this.setBackground(Color.BLACK);
        this.setBounds(0,150,1500,600);
    }


    // paints the rectangles for the graph
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        int size = values.size();
        final int widthSpace = 0;
        final double spaceGiven = WIDTH_X;

        double totalSpaceBetween = (size - 1) * widthSpace;
        int totalRectX = (int) Math.floor(((spaceGiven - totalSpaceBetween) / size));

        // the regular case where the algorithm is sorting
        int currXpos = 0;
        if (!statusDone && !postDone) {
            for (int i = 0; i < size; i++) {
                g2d.setColor(Color.WHITE);
                if (indexHighlight != -1 && i == indexHighlight) {
                    g2d.setColor(Color.RED);
                    g2d.fillRect(currXpos, HEIGHT_Y - values.get(i), totalRectX, values.get(i));
                } else {
                    g2d.fillRect(currXpos, HEIGHT_Y - values.get(i), totalRectX, values.get(i));
                }
                currXpos += totalRectX + widthSpace;
            }
        }

        // when the algorithm finishes and plays an increasing green bar up the bars of the graph
        else if (statusDone && !postDone) {
            for (int i = 0; i < size; i++) {
                g2d.setColor(Color.WHITE);
                if (indexHighlight == i) {
                    g2d.setColor(new Color(0x0EAF18));
                    g2d.fillRect(currXpos, HEIGHT_Y - values.get(i), totalRectX, values.get(i));
                } else {
                    g2d.fillRect(currXpos, HEIGHT_Y - values.get(i), totalRectX, values.get(i));
                }
                currXpos += totalRectX + widthSpace;
                this.trackLastXpos = currXpos - (totalRectX + widthSpace);
            }
        }

        // When the previous ending animation was playing and makes all the bars green at the end
        else if(statusDone && postDone){
            currXpos = this.trackLastXpos;
            for (int i = size - 1; i >= 0; i--) {
                if (indexHighlight >= i + 1) {
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(currXpos, HEIGHT_Y - values.get(i), totalRectX, values.get(i));
                }
                else {
                    g2d.setColor(new Color(0x0EAF18));
                    g2d.fillRect(currXpos, HEIGHT_Y - values.get(i), totalRectX, values.get(i));
                }
                currXpos -= totalRectX + widthSpace;
            }
        }



    }

    public void setPostDone(boolean postDone) {
        this.postDone = postDone;
    }

    public void setValues(ArrayList<Integer> values) {
        this.values = values;
    }

    public void setIndexHighlight(int indexHighlight) {
        this.indexHighlight = indexHighlight;
    }

    public void setStatusDone(boolean statusDone) {
        this.statusDone = statusDone;
    }
}