import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class mainScreen implements ActionListener{

    static JPanel mainScreen;
    public JButton[] numberButton = new JButton[25];
    public int value_Number_Button;

    Set<JButton> seen = new HashSet<JButton>();

    mainScreen(){
        mainScreen = new JPanel();
        mainScreen.setBounds(30,30,1100,700);
        mainScreen.setBackground(Color.gray);
        mainScreen.setLayout(new GridLayout(5, 5, 10, 10));

        for(int i =0; i<25; i++){
            numberButton[i] = new JButton();
            numberButton[i].addActionListener(this);
            numberButton[i].setFocusable(false);
            numberButton[i].setBackground(Color.white);
            mainScreen.add(numberButton[i]);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 25; i++){
            if(e.getSource()==numberButton[i] && !seen.contains(numberButton[i])){
                seen.add(numberButton[i]);
                value_Number_Button = i;
                mainScreen.setVisible(false);
                questionScreen();
            }
        }

    }

    public void questionScreen() {
        questionScreen.questionScreen.setVisible(true);

    }



}

