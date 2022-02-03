import javafx.application.Application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LoginGUI {
    public JTextField name = new JTextField(20);
    public JTextField age = new JTextField(10);
    public JTextField sex = new JTextField(20);
    public JTextField height = new JTextField(20);
    public JTextField weight = new JTextField(20);
    private String[] args;
    public JButton signBtn = new JButton("Sign Up");
    public JButton returnBtn = new JButton( "Returning user");

    public LoginGUI(String[] args){
        this.args = args;
        // Adding listeners to the fields to use the information later
        name.addActionListener(new signBtnListener());
        age.addActionListener(new signBtnListener());
        sex.addActionListener(new signBtnListener());
        height.addActionListener(new signBtnListener());
        signBtn.addActionListener(new signBtnListener());
        weight.addActionListener(new signBtnListener());
        returnBtn.addActionListener(new returnBtnListener());
        JFrame frame = new JFrame("Powaah Fitness Tracker");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(8,2));;

        Font f = (Font) UIManager.get("Label.font");
        UIManager.put("Label.font", f.deriveFont(23f));
        frame.add(new JLabel("Welcome to Powaah App!"));
        frame.add(new JLabel(""));

        UIManager.put("Label.font", f.deriveFont(14f));
        frame.add(new JLabel("Please enter the following information:"));
        frame.add(new JLabel(""));
        frame.add(new JLabel("Full Name:"));
        frame.add(name);
        frame.add(new JLabel("Age:"));
        frame.add(age);
        frame.add(new JLabel("Gender:"));
        frame.add(sex);
        frame.add(new JLabel("Height in inches:"));
        frame.add(height);
        frame.add(new JLabel("Enter Your Current Weight"));
        frame.add(weight);
        frame.add(signBtn);
        frame.add(returnBtn);
        frame.setVisible(true);




    }
    private class signBtnListener implements ActionListener {
        public void actionPerformed(ActionEvent e){

            String names;
            int ages;
            String Gender;
            int heights;
            try {
                names = name.getText();
                ages = Integer.parseInt(age.getText());
                Gender = sex.getText();
                int weights = Integer.parseInt(weight.getText());
                heights = Integer.parseInt(height.getText());
                // LES METHOD

               BonusMethods.writeToFile(names, Gender, ages, weights ,heights);
               CalculatorGUI g = new CalculatorGUI(args);


            }
            catch(Exception s){
                ErrorGUI g = new ErrorGUI();
            }
        }
    }
    private class returnBtnListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try {
                CalculatorGUI g = new CalculatorGUI(args);
            } catch (Exception ex) {
                ErrorGUI error = new ErrorGUI();
            }
        }
    }
    public static void main(String[] args) throws IOException {

        LoginGUI g = new LoginGUI(args);
        Scanner scan = new Scanner(System.in);
        int s = scan.nextInt();
            BonusMethods.simulateYear(s);

    }
}
