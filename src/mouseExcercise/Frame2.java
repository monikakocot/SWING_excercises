package mouseExcercise;

import javax.swing.*;
import java.awt.*;

public class Frame2 extends JFrame {

    public Frame2() {
        super("MouseTest_2");

        add(new MouseTestPanel2());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        });
    }
}
