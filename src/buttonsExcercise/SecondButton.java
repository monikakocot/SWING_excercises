package buttonsExcercise;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

class SecondButton extends JButton implements ActionListener {

    SecondButton() {
        super("Second");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setBackground(Color.YELLOW);
    }
}