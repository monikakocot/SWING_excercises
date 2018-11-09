package textExcercise.version2;

import textExcercise.version1.HTMLPanel;
import textExcercise.version1.UserValidator;
import textExcercise.version2.LoginPanelVer2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LoginListener implements ActionListener {

    //Main program Frame

    private final JFrame frame;
    //Login panel, needed to download login and password
    private LoginPanelVer2 loginPanelVer2;

    public void setPanel(LoginPanelVer2 loginPanelVer2) {
        this.loginPanelVer2 = loginPanelVer2;
    }

    public LoginListener(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String name = loginPanelVer2.getName();
        String password = loginPanelVer2.getPassword();
        if (UserValidator.authenticate(name, password)) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // panel with html editor
                    JPanel htmlPanel = new HTMLPanel();
                    // delete login panel
                    frame.getContentPane().removeAll();
                    // add panel html and refresh view
                    frame.add(htmlPanel);
                    frame.validate();
                }
            });
        }
    }
}