import javax.swing.*;
import java.awt.*;

public class ErrorGUI {

    public ErrorGUI(){
        JFrame frame = new JFrame("Powaah Fitness Tracker");
        frame.setSize(1000, 1000);

        Font f = (Font) UIManager.get("Label.font");
        UIManager.put("Label.font", f.deriveFont(40f));
        frame.setLayout(new GridLayout(2,1));
        frame.add(new JLabel("YOU DID SOMETHING STUPID, SO STUPID"));
        frame.add(new JLabel("I WOULD APPREACIATE IF YOU STOPPED"));

        frame.setVisible(true);
    }

    public ErrorGUI(String s){
        JFrame frame = new JFrame("Powaah Fitness Tracker");
        frame.setSize(1500, 1000);

        Font f = (Font) UIManager.get("Label.font");
        UIManager.put("Label.font", f.deriveFont(40f));
        frame.setLayout(new GridLayout(2,1));
        frame.add(new JLabel(s));
        frame.add(new JLabel("Please close the Window and try again"));

        frame.setVisible(true);
    }
}
