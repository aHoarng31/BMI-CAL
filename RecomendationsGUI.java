

import javafx.application.Application;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.FileNotFoundException;
import java.util.ArrayList;


import javax.swing.*;

public class RecomendationsGUI {


    public JTextArea infoTF = new JTextArea();
    public JButton graphBtn = new JButton("Show Graph");



    public RecomendationsGUI(String[] args) throws FileNotFoundException {
        infoTF.setEditable(false);
        Person p = new Person();
        try {
             p = BonusMethods.readFromFile();
        }
        catch (Exception e){
            ErrorGUI g = new ErrorGUI();
        }
        graphBtn.addActionListener(new ActionListener ()
        {
            public void actionPerformed(ActionEvent e){
                try {
                    Application.launch(totalGraph.class, args);
                }
                catch(Exception f){
                    Application.launch(totalGraph.class, args);
                }
            }
        });
        int feet = p.height/ 12;
        int inch = p.height%12;

        ArrayList<Integer> entries= BonusMethods.allWeights();
        int numEntries = entries.size();
        int high = entries.get(0);
        int low = high;

        for(Integer i: BonusMethods.allWeights()){
            if(i> high) high = i;
            if(i< low) low = i;
    }

        String total = "";

        total += "Name:  " + p.name;
        total+= "\nAge:  " + p.age;
        total += "\nGender: "+ p.gender;
        total += "\nHeight:  "+ feet+ "\'" + inch + "\"";
        total+= "\nStarting Weight:   "+ p.startWeight;
        total+= "\nCurrent Weight:  " + p.endWeight;
        total += "\nTotal Entries:  " + numEntries;
        total+= "\nHighest Weight:    " + high;
        total+= "\nLowest Weight:   " + low;




        infoTF.setText(total);


        JFrame frame = new JFrame("Your History");
        frame.setSize(600, 300);
        frame.setLayout(new GridLayout(1,2));

        frame.add(infoTF);
        frame.add(graphBtn);

        frame.setVisible(true);






    }
}

