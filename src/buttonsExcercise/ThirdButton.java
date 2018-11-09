package buttonsExcercise;

import java.awt.event.*;
import javax.swing.*;

class ThirdButton extends JButton implements ActionListener {

    private boolean clicked = false;

    ThirdButton() {
        super("Not clicked");
        addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        clicked = !clicked;

        if (clicked)
            setText("Clicked");
        else
            setText("NOT Clicked");

    }
}
