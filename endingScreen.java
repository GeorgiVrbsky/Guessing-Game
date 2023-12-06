import javax.swing.*;
import java.awt.*;

public class endingScreen {

    JPanel endingScreen;
    JTextField winLose;
    Font answer_Font = new Font("Monospaced", Font.BOLD,60);

    endingScreen(){

        endingScreen = new JPanel();
        endingScreen.setBounds(30,30,1100,700);

        winLose = new JTextField();
        winLose.setPreferredSize(new Dimension(900, 300));
        winLose.setEditable(false);
        winLose.setFont(answer_Font);
        winLose.setCaretColor(Color.WHITE);
        winLose.setText(winOrLose());

        endingScreen.add(winLose);
    }

    String winOrLose(){
        return "THE GAME HAS ENDED";
    }
}
