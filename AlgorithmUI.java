/* Frame of the project, makes a
header with its respective names and
buttons, and instantiates the bottom where
drawing will take place
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class AlgorithmUI extends JFrame implements ActionListener{
    private ImageIcon image;
    private JLabel title;
    private JLabel name;
    private JLabel runtime;
    private JLabel rank;
    private JLabel currTime;
    private JLabel numItems;
    private JLabel warning;
    private JButton start;
    private JButton submit;
    private JTextField nItems;
    private JComboBox algorithmOpp;
    private JRadioButton radioButton;
    private int n = 150;
    private ArrayList<Integer> values = randomInts();
    private CreateGraph bottom = new CreateGraph(values);
    private JPanel header = new JPanel();


    //Make all frame components
    public AlgorithmUI(){

        //initializes the frame
        this.setTitle("Visual Sorting Algorithm");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1514,787));


        //adds an icon image for tab
        image = new ImageIcon("Images/IconIMage.png");
        this.setIconImage(image.getImage());


        //initialize the panel
        header.setBounds(0,0,1500, 150);
        header.setBackground(Color.BLACK);


        //Title
        title = new JLabel();
        title.setBounds(620,5,300,30);
        title.setForeground(Color.WHITE);
        title.setText("Algorithm Visualizer");
        title.setFont(new Font("Verdana",Font.BOLD,25));
        header.add(title);


        //Name
        name = new JLabel();
        name.setBounds(690, 35,200,20);
        name.setText("By: Taiki Kawano");
        name.setFont(new Font("Verdana",Font.ITALIC,15));
        name.setForeground(Color.WHITE);
        header.add(name);

        warning = new JLabel();
        warning.setBounds(325, 110, 500, 15);
        warning.setForeground(Color.RED);
        warning.setFont(new Font("Verdana",Font.PLAIN,15));
        header.add(warning);

        //BigO runtime
        runtime = new JLabel();
        runtime.setBounds(10,5,250, 20);
        runtime.setText("Runtime Complexity: O(n^2)");
        runtime.setFont(new Font("Verdana",Font.PLAIN,15));
        runtime.setForeground(Color.WHITE);
        header.add(runtime);


        //ranking effectiveness
        rank = new JLabel();
        rank.setBounds(10,35,250, 20);
        rank.setText("Rank of Algorithm: #3");
        rank.setFont(new Font("Verdana",Font.PLAIN,15));
        rank.setForeground(Color.WHITE);
        header.add(rank);


        //Current time in seconds
        currTime = new JLabel();
        currTime.setBounds(10,70,250, 17);
        currTime.setFont(new Font("Verdana",Font.PLAIN,17));
        currTime.setForeground(new Color(0x0EAF18));
        header.add(currTime);


        //Number of items in the list
        numItems = new JLabel();
        numItems.setText("Number of items in list: ");
        numItems.setBounds(10,110,190, 20);
        numItems.setFont(new Font("Verdana",Font.PLAIN,15));
        numItems.setForeground(Color.WHITE);
        header.add(numItems);


        // Textfeild of n items with button
        nItems = new JTextField();
        nItems.setBounds(200,110,50,20);
        nItems.setBackground(Color.BLACK);
        nItems.setForeground(Color.WHITE);
        nItems.setCaretColor(Color.WHITE);
        nItems.setFont(new Font("Verdana",Font.PLAIN,15));
        String val = String.valueOf(n);
        nItems.setText(val);
        header.add(nItems);
        submit = new JButton();
        submit.setText("ENTER");
        submit.setFont(new Font("Verdana",Font.ITALIC,10));
        submit.setBackground(new Color(0x191D32));
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,110,70,20);
        submit.setFocusable(false);
        submit.addActionListener(adder);
        header.add(submit);


        //Start button
        start = new JButton();
        start.setBounds(1400,5,95,30);
        start.setText("Start");
        start.setFocusable(false);
        start.setFont(new Font("Verdana",Font.PLAIN,15));
        start.setBackground(new Color(0x0EAF18));
        start.setForeground(Color.WHITE);
        start.addActionListener(this);
        header.add(start);


        // Combo options box
        String[] options = {
                "BubbleSort", "SelectionSort", "QuickSort", "InsertionSort", "CocktailShakerSort", "BogoSort"
        };
        algorithmOpp = new JComboBox<>(options);
        algorithmOpp.setBounds(1235,5,155,30);
        algorithmOpp.setBackground(Color.WHITE);
        algorithmOpp.addActionListener(this);
        algorithmOpp.setFont(new Font("Verdana",Font.PLAIN,15));
        algorithmOpp.setForeground(Color.BLACK);
        header.add(algorithmOpp);


        // Radio button for skipping animations for instant sorting
        radioButton = new JRadioButton();
        radioButton.setText("Instant Sorting");
        radioButton.setBounds(1235,40,145,30);
        radioButton.setFont(new Font("Verdana",Font.PLAIN,15));
        radioButton.setBackground(Color.BLACK);
        radioButton.setForeground(Color.WHITE);
        radioButton.setFocusable(false);
        radioButton.addActionListener(this);
        header.add(radioButton);


        //Layout the added items for the header and bottom
        header.setLayout(new BorderLayout());
        bottom.setLayout(new BorderLayout());


        //creates the header
        this.add(header);


        // Creates Bottom Section
        this.add(bottom);

        // sets the layout for the frame which combines the header and bottom
        this.setLayout(new BorderLayout());


        //make tab visible
        this.setVisible(true);
    }


    // Method that makes a random arraylist of numbers
    private ArrayList<Integer> randomInts(){
        ArrayList<Integer> temp = new ArrayList<>();
        int listSize = n;
        int randomNumber;
        for (int i = 0; i < listSize; i++) {
            randomNumber = (int) (Math.random() * 500) + 1;
            temp.add(i,randomNumber);
        }
        return temp;
    }


    //Start and Reset Buttons
    @Override
    public void actionPerformed(ActionEvent e) {

        // Variables for the time it takes for each algorithm
        long startTime, endTime, result;

        // BubbleSort called
        if(Objects.equals(algorithmOpp.getSelectedItem(), "BubbleSort")){
            bottom.setPostDone(false);
            bottom.setStatusDone(false);
            BubbleSort bubbleSort = new BubbleSort(values, bottom);
            runtime.setText("Runtime Complexity: " + bubbleSort.getRunTime());
            rank.setText("Rank of Algorithm: #" + bubbleSort.getRank());
            nItems.setText(String.valueOf(150));
            warning.setText("");
            if(e.getSource() == start && !radioButton.isSelected()){
                startTime = System.currentTimeMillis();
                bubbleSort.doBubbleSort();
                endTime = System.currentTimeMillis();
                result = endTime - startTime;
                currTime.setText("Time taken " + result + "ms");
                bubbleSort.postAnimation();
            }
            else if (e.getSource() == start && radioButton.isSelected()) {
                startTime = System.currentTimeMillis();
                bubbleSort.doInstantBubbleSort();
                endTime = System.currentTimeMillis();
                result = endTime - startTime;
                currTime.setText("Time taken " + result + "ms");
                bubbleSort.postAnimation();
            }
        }

        //SelectionSort called
        else if (Objects.equals(algorithmOpp.getSelectedItem(), "SelectionSort")) {
            bottom.setPostDone(false);
            bottom.setStatusDone(false);
            SelectionSort selectionSort = new SelectionSort(values, bottom);
            runtime.setText("Runtime Complexity: " + selectionSort.getRunTime());
            rank.setText("Rank of Algorithm: #" + selectionSort.getRank());
            nItems.setText(String.valueOf(150));
            warning.setText("");
            if(e.getSource() == start && !radioButton.isSelected()){
                startTime = System.currentTimeMillis();
                selectionSort.doSelectionSort();
                endTime = System.currentTimeMillis();
                result = endTime - startTime;
                currTime.setText("Time taken " + result + "ms");
                selectionSort.postAnimation();
            }
            else if (e.getSource() == start && radioButton.isSelected()) {
                startTime = System.currentTimeMillis();
                selectionSort.doInstantSelctionSort();
                endTime = System.currentTimeMillis();
                result = endTime - startTime;
                currTime.setText("Time taken " + result + "ms");
                selectionSort.postAnimation();
            }
        }
        // Insertion sort called
        else if (Objects.equals(algorithmOpp.getSelectedItem(), "InsertionSort")) {
            bottom.setPostDone(false);
            bottom.setStatusDone(false);
            InsertionSort insertionSort = new InsertionSort(values, bottom);
            runtime.setText("Runtime Complexity: " + insertionSort.getRunTime());
            rank.setText("Rank of Algorithm: #" + insertionSort.getRank());
            nItems.setText(String.valueOf(150));
            warning.setText("");
            if(e.getSource() == start && !radioButton.isSelected()){
                startTime = System.currentTimeMillis();
                insertionSort.doInsertionSort();
                endTime = System.currentTimeMillis();
                result = endTime - startTime;
                currTime.setText("Time taken " + result + "ms");
                insertionSort.postAnimation();
            }
            else if (e.getSource() == start && radioButton.isSelected()) {
                startTime = System.currentTimeMillis();
                insertionSort.doInstantInsertionSort();
                endTime = System.currentTimeMillis();
                result = endTime - startTime;
                currTime.setText("Time taken " + result + "ms");
                insertionSort.postAnimation();
            }
        }
        // QuickSort called
        else if (Objects.equals(algorithmOpp.getSelectedItem(), "QuickSort")) {
            bottom.setPostDone(false);
            bottom.setStatusDone(false);
            QuickSort quickSort = new QuickSort(values,bottom);
            runtime.setText("Runtime Complexity: " + quickSort.getRunTime());
            rank.setText("Rank of Algorithm: #" + quickSort.getRank());
            nItems.setText(String.valueOf(150));
            warning.setText("");
            if(e.getSource() == start && !radioButton.isSelected()){
                startTime = System.currentTimeMillis();
                quickSort.doQuickSort();
                endTime = System.currentTimeMillis();
                result = endTime - startTime;
                currTime.setText("Time taken " + result + "ms");
                quickSort.postAnimation();
            }
            else if (e.getSource() == start && radioButton.isSelected()) {
                startTime = System.currentTimeMillis();
                quickSort.doInstantQuicksort();
                endTime = System.currentTimeMillis();
                result = endTime - startTime;
                currTime.setText("Time taken " + result + "ms");
                quickSort.postAnimation();
            }
        }
        // Cocktail shaker sort called
        else if (Objects.equals(algorithmOpp.getSelectedItem(), "CocktailShakerSort")) {
            bottom.setPostDone(false);
            bottom.setStatusDone(false);
            CocktailShakerSort cocktailShakerSort = new CocktailShakerSort(values, bottom);
            runtime.setText("Runtime Complexity: " + cocktailShakerSort.getRunTime());
            rank.setText("Rank of Algorithm: #" + cocktailShakerSort.getRank());
            nItems.setText(String.valueOf(150));
            warning.setText("");
            if(e.getSource() == start && !radioButton.isSelected()){
                startTime = System.currentTimeMillis();
                cocktailShakerSort.doCocktailShakerSort();
                endTime = System.currentTimeMillis();
                result = endTime - startTime;
                currTime.setText("Time taken " + result + "ms");
                cocktailShakerSort.postAnimation();
            }
            else if (e.getSource() == start && radioButton.isSelected()) {
                startTime = System.currentTimeMillis();
                cocktailShakerSort.doInstantCocktailShakerSort();
                endTime = System.currentTimeMillis();
                result = endTime - startTime;
                currTime.setText("Time taken " + result + "ms");
                cocktailShakerSort.postAnimation();
            }
        }
        // BogoSort sort called
        else if (Objects.equals(algorithmOpp.getSelectedItem(), "BogoSort")) {
            bottom.setPostDone(false);
            bottom.setStatusDone(false);
            BogoSort bogoSort = new BogoSort(values, bottom);
            runtime.setText("Runtime Complexity: " + bogoSort.getRunTime());
            rank.setText("Rank of Algorithm: #" + bogoSort.getRank());
            nItems.setText(String.valueOf(5));
            warning.setText("WARNING!! DON'T GO OVER INPUT OF 5!!");
            if(e.getSource() == start && !radioButton.isSelected()){
                startTime = System.currentTimeMillis();
                bogoSort.doBogoSort();
                endTime = System.currentTimeMillis();
                result = endTime - startTime;
                currTime.setText("Time taken " + result + "ms");
                bogoSort.postAnimation();
            }
            else if (e.getSource() == start && radioButton.isSelected()) {
                startTime = System.currentTimeMillis();
                bogoSort.doInstantBogoSort();
                endTime = System.currentTimeMillis();
                result = endTime - startTime;
                currTime.setText("Time taken " + result + "ms");
                bogoSort.postAnimation();
            }
        }


        bottom.setPostDone(true);
        bottom.setStatusDone(true);
    }


    // when the textfeild button is pressed, for making n random items
    ActionListener adder = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submit) {
                try {
                    bottom.setPostDone(false);
                    bottom.setStatusDone(false);
                    currTime.setText("");
                    String input = nItems.getText();
                    if (input.isEmpty()) {
                        // Handle the case where the input is empty
                        JOptionPane.showMessageDialog(null, "Please enter a value.");
                        return;
                    }

                    n = Integer.parseInt(input);
                    if (n < 2 || n > 1500) {
                        // Handle the case where the input is not within the desired range
                        JOptionPane.showMessageDialog(null, "Please enter a valid number from 2 to 1500.");
                        nItems.setText("");
                    } else {
                        values = randomInts();
                        bottom.setValues(values);
                        bottom.repaint();
                    }
                } catch (NumberFormatException ex) {
                    // Handle the case where the input is not a valid number
                    JOptionPane.showMessageDialog(null, "Please enter a valid number from 2 to 1500.");
                    nItems.setText("");
                }
            }
        }
    };

}
