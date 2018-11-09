package keyBoardExcercise;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.EventQueue;
import javax.swing.*;

public class KeyTest extends JFrame implements KeyListener {

    private int counter = 0; // - counts on which character of the password we are in. If the letter is entered
    // does not match this in the password, the entire "secret" sequence must be entered from the beginning, the counter variable is set to 0.
    private String userInput = "";
    // userInput - string is built on a regular basis while pressing next keys by the user.
    // Similar to the counter variable, it is reset when the user enters an incorrect letter.
    private final String secret = "secret";


    JPanel keyPanel = new JPanel();

    public KeyTest() {
        super("KeyListener Test");

        setPreferredSize(new Dimension(500, 500));
        addKeyListener(this); // this because JFrame is listener

        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(keyPanel);
    }

    @Override
    public void keyPressed(KeyEvent evt) {
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        char c = evt.getKeyChar();
        if(counter < secret.length())
            checkSecret(c); // definition below
    }

    @Override
    public void keyTyped(KeyEvent evt) {

    }

    private void checkSecret(char c) {
        if(c == secret.charAt(counter)) {
            counter++;
            userInput = userInput+c;
        }
        else {
            counter = 0;
            userInput = "";
        }

        if(userInput.equals(secret)) {
            setTitle("Secret password");
            keyPanel.setBackground(Color.RED);
            JOptionPane.showMessageDialog(null, "YOU guessed secret password :)");
        }
    }


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KeyTest();
            }
        });
    }
}




