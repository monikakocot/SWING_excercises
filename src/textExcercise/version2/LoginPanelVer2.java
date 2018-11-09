package textExcercise.version2;

import javax.swing.*;
import java.awt.*;

public class LoginPanelVer2 extends JPanel {
    private JTextField nameField;
    private JPasswordField passField;
    private JButton loginButton;
    private LoginListener listener;

    //@return username entered by User

    public String getName() {
        return nameField.getText();
    }
    // @return password entered by User

    public String getPassword() {
        String password = "";
        char[] pass = passField.getPassword();
        for(int i=0; i<pass.length; i++) {
            password += pass[i];
        }
        return password;
    }

    public LoginPanelVer2(LoginListener listener) { //
        super();
        // set layout
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag);
        // create login components
        this.listener = listener;
        this.listener.setPanel(this);
        createComponents();
    }


    //A method that creates labels and fields for entering data.

    private void createComponents() {
        JLabel name = new JLabel("Name: ");
        JLabel password = new JLabel("Password: ");
        nameField = new JTextField();
        passField = new JPasswordField();

        // Help panel for entering data

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(name);
        inputPanel.add(nameField);
        inputPanel.add(password);
        inputPanel.add(passField);

        //create login button

        loginButton = new JButton("Login");
        loginButton.addActionListener(listener);

        //help to center elements
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(inputPanel, BorderLayout.CENTER);
        parentPanel.add(loginButton, BorderLayout.SOUTH);


        this.add(parentPanel);
    }

}