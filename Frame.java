import javax.swing.*;
import java.awt.*;

public class Frame {

    JFrame frame;
    mainScreen mainScreen;
    questionScreen questionScreen;

    public Frame(){
        frame = new JFrame("Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1180,800);
        frame.setBackground(Color.gray);
        frame.setResizable(false);
        frame.setLayout(null);

        mainScreen mainScreen = new mainScreen();
        questionScreen questionScreen = new questionScreen();
        endingScreen endingScreen = new endingScreen();

        frame.add(mainScreen.mainScreen);
        frame.add(questionScreen.questionScreen);
        frame.add(endingScreen.endingScreen);
        frame.setVisible(true);
    }

}
