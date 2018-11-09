package textExcercise.version1;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
W klasie tej musimy przechowywać referencję do ramki, aby usunąć z niej panel logowania.
Robimy to jednak dopiero po zweryfikowaniu loginu i hasła - dlatego w klasie
LoginPanel przekazaliśmy referencję this do klasy LoginListener za pomocą metody setPanel().

Po zweryfikowaniu loginu i hasła usuwamy z ramki panel logowania i dodajemy nowy panel obsługi html.
Dodatkowo podczas tej operacji praktycznie wszystkie komponenty tracą swoją ważność, należy je więc
odświeżyć za pomocą metody validate(). Dzięki wywołaniu jej na obiekcie frame odnowimy praktycznie
wszystko co nas interesuje, ponieważ odnawia ona również komponenty podrzędne (podobny efekt uzyskuje się na
przykład rozszerzając okno programu).
 */

// Here without use LoginListener Class

public class LoginPanel extends JPanel implements ActionListener{

    private JTextField nameField;
    private JPasswordField passField;
    private JButton loginButton;

    //private LoginListener listener; //button listener
    //Login panel, needed to download login and password
    //JFrame frame = new JFrame();

     private JFrame frame;

    public LoginPanel (JFrame frame){ // it must be connected to the frame because part of the code from the action handler concerns Frame
        super();

        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);
        GridBagConstraints constraints = new GridBagConstraints();
        gridBag.setConstraints(this, constraints);
        constraints.fill = GridBagConstraints.CENTER;

        //components for login

        JLabel name = new JLabel("Name: ");
        JLabel password = new JLabel("Password: ");
        nameField = new JTextField();
        passField = new JPasswordField();

        //help panel for entering data
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(name);
        inputPanel.add(nameField);
        inputPanel.add(password);
        inputPanel.add(passField);

        this.add(inputPanel);

        //login button
        loginButton = new JButton("Login");
        inputPanel.add(loginButton);
        loginButton.addActionListener(this);

        //help to center elements
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());

        parentPanel.add(inputPanel, BorderLayout.CENTER);
        parentPanel.add(loginButton, BorderLayout.SOUTH);

        this.add(parentPanel);
        this.frame=frame;
    }

    /*
     @return wprowadzona nazwa użytkownika
     */
    public String getName() {
        return nameField.getText();
    }

    /*
     @return wprowadzone przez użytkownika hasło
     */

    public String getPassword() {
        String password = "";

        char[] pass = passField.getPassword();
        for(int i=0; i<pass.length; i++) {
            password += pass[i];
        }
        return password;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String name = nameField.getText();

        // conversion of character table to String
        char[] pass = passField.getPassword();
        String password = "";
        for(int i=0; i<pass.length; i++) {
            password += pass[i];
        }

        if (UserValidator.authenticate(name, password)) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // panel with html editor
                    JPanel htmlPanel = new HTMLPanel();
                    // we delete login panel
                    frame.getContentPane().removeAll();
                    // we add html panel and refresh view
                    frame.add(htmlPanel);
                    frame.validate();
                }
            });
        }
    }

}


// MÓJ PANEL
// Działający PANEL


/*
public class LoginPanel extends JPanel {
    private JTextField nameField; //pole na nazwę
    private JPasswordField passField; //pole na hasło
    private JButton loginButton; //przycisk logowania
    private LoginListener listener; //słuchacz przycisku


     //@return wprowadzona nazwa użytkownika

    public String getName() {
        return nameField.getText();
    }


     // @return wprowadzone przez użytkownika hasło

    public String getPassword() {
        String password = "";
        char[] pass = passField.getPassword();
        for(int i=0; i<pass.length; i++) {
            password += pass[i];
        }
        return password;
    }

    public LoginPanel(LoginListener listener) { //
        super();
        // ustawiamy layout
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;
        gridBag.setConstraints(this, constraints);
        setLayout(gridBag);
        // tworzymy komponenty logowania
        this.listener = listener;
        this.listener.setPanel(this);
        createComponents();
    }


     //Metoda, która tworzy etykiety i pola do wprowadzania danych.

    private void createComponents() {
        JLabel name = new JLabel("Name: ");
        JLabel password = new JLabel("Password: ");
        nameField = new JTextField();
        passField = new JPasswordField();

        //pomocniczy panel do wprowadzania danych
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(name);
        inputPanel.add(nameField);
        inputPanel.add(password);
        inputPanel.add(passField);
        //tworzymy przycisk logowania
        loginButton = new JButton("Zaloguj");
        loginButton.addActionListener(listener);

        //pomocniczy panel do wyśrodkowania elementów
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(inputPanel, BorderLayout.CENTER);
        parentPanel.add(loginButton, BorderLayout.SOUTH);

        // dodajemy do głównego panelu
        this.add(parentPanel);
    }


}

*/