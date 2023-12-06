import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Random;

public class questionScreen implements ActionListener{

    String question = null;
    String answer = null;
    int chechingWin;
    mainScreen mainScreen = new mainScreen();
    endingScreen endingScreen = new endingScreen();

    static JPanel questionScreen;
    JTextField textFieldQuestion, textFieldAnswer;
    JButton button;
    Font answer_Font = new Font("Monospaced", Font.BOLD,60);
    Font question_Font = new Font("Monospaced", Font.BOLD,30);
    Font buttonFont = new Font("Monospaced", Font.BOLD,15);

    Action action = new AbstractAction()
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            questionScreen.setVisible(false);
            if(textFieldAnswer.getText().equals(answer)){
                mainScreen.numberButton[mainScreen.value_Number_Button].setBackground(Color.green);
                mainScreen.numberButton[mainScreen.value_Number_Button].setText(answer);
            }
            else{
                mainScreen.numberButton[mainScreen.value_Number_Button].setBackground(Color.red);
                mainScreen.numberButton[mainScreen.value_Number_Button].setText(answer);
            }
            chechingWin = checking_Win();
            if(chechingWin==0){
                resetField();
                mainScreen();
            }
        }
    };


    questionScreen(){
        questionScreen = new JPanel();
        questionScreen.setBounds(30,30,1100,700);
        questionScreen.setBackground(Color.gray);


        textFieldQuestion = new JTextField();
        textFieldQuestion.setPreferredSize(new Dimension(900, 300));
        textFieldQuestion.setEditable(false);
        textFieldQuestion.setCaretColor(Color.WHITE);
        textFieldQuestion.setFont(question_Font);

        try {
            questions();
        } catch (Exception exception) {
            exception.printStackTrace();
        }


        textFieldAnswer = new JTextField();
        textFieldAnswer.setPreferredSize(new Dimension(800, 100));
        textFieldAnswer.setCaretColor(Color.WHITE);
        textFieldAnswer.addActionListener( action );
        textFieldAnswer.setFont(answer_Font);

        button = new JButton("Answer");
        button.setFont(buttonFont);
        button.setBackground(Color.white);
        button.addActionListener(this);
        button.setFocusable(false);
        button.setSize(167,100);

        questionScreen.add(textFieldQuestion);
        questionScreen.add(textFieldAnswer);
        questionScreen.add(button);

    }



    public void questions() throws Exception {

        File file = new File("src/questions.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        Random rand = new Random();

        int random = rand.nextInt(50 + 1);
        int random_checker = 0;

        while ((st = br.readLine()) != null){
            if(random_checker==random){
                for(int i = 0; i < st.length(); i++){
                    if(st.charAt(i)=='|'){
                        question = st.substring(0,i).trim();
                        answer = st.substring(i+1).trim();
                    }
                }
            }
            random_checker++;

        }

        textFieldQuestion.setText(question);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            questionScreen.setVisible(false);
            if(textFieldAnswer.getText().equals(answer)){
                mainScreen.numberButton[mainScreen.value_Number_Button].setBackground(Color.green);
                mainScreen.numberButton[mainScreen.value_Number_Button].setText(answer);
            }
            else{
                mainScreen.numberButton[mainScreen.value_Number_Button].setBackground(Color.red);
                mainScreen.numberButton[mainScreen.value_Number_Button].setText(answer);
            }
            chechingWin = checking_Win();
            if(chechingWin==0){
                resetField();
                mainScreen();
            }

        }
    }

    int checking_Win(){

        for(int i = 0; i < 5; i++){
            int RowsGreen = 0;
            int ColumnsGreen = 0;
            int RowsRed = 0;
            int ColumnsRed = 0;
            for(int j = (i*5); j < (i*5) + 5; j++){
                if(mainScreen.numberButton[j].getBackground() == Color.green){
                    RowsGreen++;
                }
                if(mainScreen.numberButton[j].getBackground() == Color.red){
                    RowsRed++;
                }
            }
            for(int k = 0; k < 5; k++){
                if(mainScreen.numberButton[k*5+i].getBackground() == Color.green){
                    ColumnsGreen++;
                }
                if(mainScreen.numberButton[k*5+i].getBackground() == Color.red){
                    ColumnsRed++;
                }
            }

            if(RowsGreen==5 || ColumnsGreen==5 || RowsRed==5 || ColumnsRed==5){
                questionScreen.setVisible(false);
                endingScreen();
                return 1;
            }
        }
        return 0;
    }

    private void resetField(){
        textFieldQuestion.setText("");
        textFieldAnswer.setText("");
        try {
            questions();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void endingScreen(){
        endingScreen.endingScreen.setVisible(true);
    }

    public void mainScreen() {
        mainScreen.mainScreen.setVisible(true);
    }

}

