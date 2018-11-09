package textExcercise.version2;

import javax.swing.*;
import java.awt.*;

public class FrameVer2 extends JFrame {

    public FrameVer2() {
        super("Text Components");
        LoginListener listener = new LoginListener(this);
        JPanel loginPanelVer2 = new LoginPanelVer2(listener);
        //JPanel loginPanel = new LoginPanel(this);
        add(loginPanelVer2);

        setPreferredSize(new Dimension(600, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
}