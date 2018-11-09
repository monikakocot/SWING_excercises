package textExcercise.version2;

import java.awt.EventQueue;

/*
Excercise with Login Panel and Panel which convert HTML code to text.
login: tajniak
password: 1234
 */

public class MainVer2 {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameVer2();
            }
        });
    }
}
