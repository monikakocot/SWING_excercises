package textExcercise.version1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/*
JTextField - field in which we will enter our html code in the form of plain textExcercise

JEditorPane - a panel that allows you to display code containing HTML 3.2 tags,
as well as pictures. We have disabled the option of editing on this page using the sedEditable (false) method,
and we set the type of content as the html code (textExcercise / html).

ADDITIONAL FUNCTIONALITY:
To the example from the lesson, add the functionality that the preview will be generated on a regular basis together
with textExcercise entered by the user.

The change was really small - all you had to do was add the keyboard event listener, or KeyListener to the JTextArea object,
where we enter the HTML code. As a result of entering or deleting consecutive characters, it is enough to update the state of the JEditorPane object,
which displays the processed HTML code. Because the keyPressed method from the KeyListener interface is enough to handle everything
it is enough to extend the KeyAdapter class - we do not have to leave the empty keyTyped and keyReleased methods in the code.

 */

public class HTMLPanel extends JPanel {
    //field for entering the html code
    private final JTextArea textArea = new JTextArea();
    //field with the generated code
    private final JEditorPane editorPane = new JEditorPane();

    public HTMLPanel() {
        super();
        setLayout(new BorderLayout());
        createPanels(); // implementation below
    }

    private void createPanels() {
        //we do not want to be able to edit the generated html
        editorPane.setEditable(false);
        //we set our editorPane to recognize html tags
        editorPane.setContentType("text/html");
        //preview button
        JButton actionButton = new JButton("Preview");
        //actionButton.addActionListener(new ConvertListener()); // preview will be generated after click action button 'preview'
        // in this case we can delete addKeyListener

        //help panel for organise elements

        JPanel helpPanel = new JPanel();
        helpPanel.setLayout(new GridLayout(1, 2));
        textArea.setBackground(Color.lightGray);

        textArea.addKeyListener(new MyKeyListener()); // preview will be generated together  with textExcercise entered by the user.
        // in this case we can delete addActionListener

        helpPanel.add(textArea);
        helpPanel.add(editorPane);

        //we add everything to the main panel
        this.add(helpPanel, BorderLayout.CENTER);
        this.add(actionButton, BorderLayout.SOUTH);
    }

    // preview will be generated after click action button 'preview'
    class ConvertListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            //change the appearance of the call in the event distribution thread
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    String text = textArea.getText();
                    editorPane.setText(text);
                    editorPane.revalidate();
                }
            });
        }
    }
    //preview will be generated after click action button 'preview'

    //preview will be generated together  with textExcercise entered by the user.
    class MyKeyListener extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent arg0) {
            //zmiany wyglądu wywołujemy w wątku dystrybucji zdarzeń
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    String text = textArea.getText();
                    editorPane.setText(text);
                    //editorPane.revalidate(); // nic nie zmienia
                }
            });
        }
    }
    //preview will be generated together  with textExcercise entered by the user.
}
