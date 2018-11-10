package mixExcercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener {

    public static final int HEIGHT = 200;
    public static final int WIDTH = 300;
    private JButton greenButton;
    private JButton blueButton;
    private JButton redButton;

    public ButtonPanel() {
        greenButton = new JButton("Green");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");

        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(greenButton);
        add(blueButton);
        add(redButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == greenButton)
            setBackground(Color.GREEN);

        else if(source == blueButton)
            setBackground(Color.BLUE);

        else if(source == redButton)
            setBackground(Color.RED);
    }
}

 /*
    // ButtonPanel - divided into subclasses

    public class ButtonPanel extends JPanel{

        public static final int HEIGHT = 100;
        public static final int WIDTH = 300;
        private JButton greenButton;
        private JButton blueButton;
        private JButton redButton;

        private JPanel buttonPanel;

        public ButtonPanel() {
            greenButton = new GreenButton();
            blueButton = new BlueButton();
            redButton = new RedButton();

            buttonPanel = this;

            setLayout(new FlowLayout());
            setPreferredSize(new Dimension(WIDTH, HEIGHT));
            add(greenButton);
            add(blueButton);
            add(redButton);
        }

        class GreenButton extends JButton implements ActionListener {

            GreenButton() {
                super("Green");
                addActionListener(this);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setBackground(Color.GREEN);
            }
        }

        class BlueButton extends JButton implements ActionListener {

            BlueButton() {
                super("Blue");
                addActionListener(this);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setBackground(Color.BLUE);
            }
        }

        class RedButton extends JButton implements ActionListener {

            RedButton() {
                super("Red");
                addActionListener(this);
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                buttonPanel.setBackground(Color.RED);
            }
        }

    }
    */

