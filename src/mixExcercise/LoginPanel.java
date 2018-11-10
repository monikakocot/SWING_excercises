package mixExcercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel implements ActionListener {

    private JTextField nameField;
    private JPasswordField passField;
    private JButton loginButton;

    //private LoginListener listener; //button listener
    //Login panel, needed to download login and password
    //JFrame frame = new JFrame();

    private MyFrame frame;

    public LoginPanel (MyFrame frame){ // it must be connected to the frame because part of the code from the action handler concerns Frame
        super();

        GridBagLayout gridBag = new GridBagLayout();
        setLayout(gridBag);
/*
GridBagLayout is one of the most flexible — and complex — layout managers the Java platform provides.
A GridBagLayout places components in a grid of rows and columns, allowing specified components to span multiple rows or columns.
Not all rows necessarily have the same height. Similarly, not all columns necessarily have the same width. Essentially, GridBagLayout
places components in rectangles (cells) in a grid, and then uses the components' preferred sizes to determine how big the cells should be.

The GridBagConstraints class specifies constraints for components that are laid out using the GridBagLayout class.

BorderLayout lays out a container, arranging and resizing its components to fit in five regions: north, south, east, west, and center.
Each region may contain no more than one component, and is identified by a corresponding constant: NORTH, SOUTH, EAST, WEST, and CENTER.
When adding a component to a container with a border layout, use one of these five constants.
 */
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
   @return input user name
   */
    public String getName() {
        return nameField.getText();
    }

/*
@return input user password
*/

    public String getPassword() {

        char[] pass = passField.getPassword();
        String password = "";
        for(int i=0; i<pass.length; i++) {
            password += pass[i];
        }
        return password;
    }

    @Override
    public void actionPerformed(ActionEvent event) {

        String name = this.getName();
        String  password = this.getPassword();

        if (mixExcercise.UserValidator.authenticate(name, password)) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    // panel with html editor

                    JPanel htmlPanel = new HTMLPanel();
                    // we delete panels
                    frame.getContentPane().removeAll();

                    frame.add(htmlPanel);
                    frame.setPreferredSize(new Dimension(500, 200));
                    frame.setLayout(new GridLayout(1, 1));

                    frame.revalidate();
                    frame.pack();
                    frame.repaint();

                    new KeyFrame();
                }
            });
        }
    }
}

/*
Validates this container and all of its subcomponents.

Validating a container means laying out its subcomponents. Layout-related changes, such as setting the bounds of a component, or adding a
component to the container, invalidate the container automatically. Therefore, to restore the validity of the hierarchy, the validate() method
should be invoked on the top-most invalid container of the hierarchy.
 */


