package mixExcercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HTMLPanel extends JPanel {
    //field for entering the html code
    private final JTextArea textArea = new JTextArea();
    //field with the generated code
    private final JEditorPane editorPane = new JEditorPane();

    public HTMLPanel() {
        super();
        setLayout(new BorderLayout());
        createPanels(); // implementation below
        setPreferredSize(new Dimension(500, 800));

    }

    private void createPanels() {
        //we do not want to be able to edit the generated html
        editorPane.setEditable(false);
        //we set our editorPane to recognize html tags
        editorPane.setContentType("text/html");
        editorPane.setSize(250,200);
        //preview button

        JButton actionButton = new JButton("Preview");
        //actionButton.addActionListener(new ConvertListener()); // preview will be generated after click action button 'preview'
        // in this case we can delete addKeyListener

        //help panel for organise elements

        JPanel helpPanel = new JPanel();
        helpPanel.setLayout(new GridLayout(1, 2));
        textArea.setBackground(Color.lightGray);
        textArea.setSize(250,200);

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

