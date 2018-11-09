package textExcercise.version1;

/*
Excercise with Login Panel and Panel which convert HTML code to text.
login: tajniak
password: 1234
 */

import java.awt.EventQueue;
public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        });
    }
}