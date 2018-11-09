package pictureExcercise;

import javax.swing.*;

public class Frame extends JFrame {

    public Frame() {
        super("Picture programm");

        JPanel picturePanel = new Panel();
        add(picturePanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

}


