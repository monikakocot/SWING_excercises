package buttonsExcercise;


/*

Write an application using elements of AWT and Swing, which contains three buttons:
The first one changes the panel's background color to a random color: green, blue, or red.
The second button changes your own background to any color defined by you. (Use the setBackground (Color) method of the JButton class)
The third button changes its label to "Pressed" when pressed. (Use the setText (String) method of the JButton class)
Define all elements in separate classes (external) and use one of the managers schedule.

 */
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel{

    public static final int HEIGHT = 100;
    public static final int WIDTH = 300;

    private JButton greenButton;
    private JButton blueButton;
    private JButton redButton;

    public ButtonPanel() {
        greenButton = new FirstButton(this);
        blueButton = new SecondButton();
        redButton = new ThirdButton();

        add(greenButton);
        add(blueButton);
        add(redButton);

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

    }
}