package mixExcercise;
/*
A frame with several Panels that uses the knowledge of functionality so far:
1. Drawing geometrical figures
2. Display the image
3. Button actions
4. Login action
 */
import javax.swing.*;
import java.awt.*;
import javax.swing.JPanel;

public class MyFrame extends JFrame {

    JPanel geometricalPanel = new GeometricalPanel();
    JPanel picturePanel = new PicturePanel();
    JPanel buttonPanel = new ButtonPanel();
    JPanel loginpanel = new LoginPanel(this);

    public MyFrame() {
        super("Our Mix :D");

        // Panels are component's containers

        add(geometricalPanel);
        add(picturePanel);
        add(buttonPanel);
        add(loginpanel);

        setLayout(new GridLayout(4, 1));

        setPreferredSize(new Dimension(500, 800));
        pack(); // adjusts the frame size to content
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public JPanel getGeometricalPanel() {
        return geometricalPanel;
    }

    public void setGeometricalPanel(JPanel geometricalPanel) {
        this.geometricalPanel = geometricalPanel;
    }

    public JPanel getPicturePanel() {
        return picturePanel;
    }

    public void setPicturePanel(JPanel picturePanel) {
        this.picturePanel = picturePanel;
    }

    public JPanel getButtonPanel() {
        return buttonPanel;
    }

    public void setButtonPanel(JPanel buttonPanel) {
        this.buttonPanel = buttonPanel;
    }

    public JPanel getLoginpanel() {
        return loginpanel;
    }

    public void setLoginpanel(JPanel loginpanel) {
        this.loginpanel = loginpanel;
    }
}
    // POLE TEKSOWE

    //Komponenty, do których można wprowadzać jedynie "czysty" tekst: JTextField, JFormattedTextField, JPasswordField, JTextArea
   // Komponenty, które dodatkowo obsługują różne style oraz można w nich wyświetlać obrazki: JTextPane, JEditorPane
/*

Pierwsza grupa jest najczęściej stosowana, a konkretnie JTextField i JTextArea. Odróżnia je to, że pierwszy z nich pozwala odczytywać
dane w jednej linii tekstu (przykładowo imię, nazwisko itp.), JTextArea z kolei może mieć większe rozmiary, więc świetnie nada się do
 odbierania większych porcji tekstu. Wymieniono tu również JPasswordField - pole do wprowadzania hasła, które automatycznie zamienia
 wpisywane znaki na kropi, lub ustalone przez nas znaki. JFormattedField pozwoli z kolei odczytywać dane w ustalonej przez nas formie.

W drugiej grupie znajdują się elementy, które obsługują dodatkowo podstawowe znaczniki języka HTML.
Można z dzięki nim zrobić w bardzo prosty sposób przeglądarkę prostych stron. Należy jednak uważać,
ponieważ obsługiwane są znaczniki jedynie do wersji HTML 3.2 - nie poszalejemy więc za bardzo.
 */












