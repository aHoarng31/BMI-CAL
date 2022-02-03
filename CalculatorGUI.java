import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.*;


public class CalculatorGUI {
    public JTextField genderTF;
    private String[] args;
    public JTextField weightTF = new JTextField((20));
    public JTextField Results= new JTextField(20);
    public JTextArea recomendations = new JTextArea();
//    public ImageIcon bmi = new ImageIcon(getClass().getResource("BMI.jpg"));
    public JTextField  BMITF = new JTextField(23);
    public JButton storeBtn = new JButton("Store this Data");
    public JButton futureBtn = new JButton("Recommendations");
    public JButton historyBtn = new JButton("See Past History");
    JLabel reco = new JLabel("Here is what we recommend");

    public CalculatorGUI(String[] args) throws IOException {
        this.args = args;
        // Stores the data
        storeBtn.addActionListener(new CalculateBtnListener());
        weightTF.addActionListener(new CalculateBtnListener());

        // Shows Recomendations
        futureBtn.addActionListener(new futureBtnListener());
//        recomendations.addActionListener((new futureBtnListener()));

        // Shows Past Data;
        historyBtn.addActionListener(new HistoryBtnListener());

        reco.setVisible(false);

        recomendations.setLineWrap(true);
        recomendations.setWrapStyleWord(true);
        recomendations.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        BMITF.setVisible(false);



        JFrame content = new JFrame("Powhaa Fitness Tracker");
       content.setSize(800,400);
        content.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        content. setLayout(new GridLayout(5,2));



        content.add(new JLabel("This is where you can track your weight"));
        content.add(new JLabel());
        content.add(new JLabel("Enter your current weight"));
        content.add(weightTF);

        content.add(storeBtn);
        content.add(futureBtn);
        content.add(historyBtn);
        content.add(new JLabel(""));
        BufferedImage img = ImageIO.read(new File("BMI.jpg"));
        content.setIconImage(img);

        //Recommendation stuff

        content.add(reco);
        content.add(recomendations);

        content.setVisible(true);



    }
    // Stores the Data to the Text File
    private class CalculateBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(weightTF.getText().equals("")){
                ErrorGUI x =new ErrorGUI("You need to enter a Weight At Least");
            }
            else {
                int weight = Integer.parseInt(weightTF.getText());

                try {
                    BonusMethods.writeToFile(weight);
                    weightTF.setText("");
                } catch (IOException ex) {
                    ErrorGUI g = new ErrorGUI();
                }
            }
        }
    }

    // Shows Recomendations
    private class futureBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            try {
                recomendations.setText(BonusMethods.Recommendations(BonusMethods.readFromFile()));
                recomendations.setVisible(true);
                reco.setVisible(true);
            } catch (Exception ex) {
                ErrorGUI g = new ErrorGUI("You aren't a returning user and you know it so why are you here");
            }
        }
    }
    private class HistoryBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            try {
                RecomendationsGUI g = new RecomendationsGUI(args);
            } catch (Exception be) {
                ErrorGUI t = new ErrorGUI();
            }
        }
    }

}







