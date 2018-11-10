package mixExcercise;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class GeometricalPanel extends JPanel {

    public GeometricalPanel() {
        setPreferredSize(new Dimension(500, 200));
    }
    // component in the Panel with the Rectangle and the Circle
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Rectangle
        Rectangle2D rectangle = new Rectangle2D.Double(0, 0, 480, 180);
        // Circle
        Ellipse2D circle = new Ellipse2D.Double(190, 18, 100, 100);

        g2d.draw(rectangle);
        g2d.draw(circle);

/*
Does not call the method "paintComponent (Graphics g)
All magic is that this method can not be called directly. It does this through the repaint () method
invoked for an object that overloads the paintComponent or paint method:

1. The GeometricalPanel class inherits from JPanel, which inherits from several other classes.
   We overload her paintComponent method and want to make - besides what she did - draw some rectangle and circle.
   Maybe this method has not done anything, maybe it did something (you can check it, but it does not matter) -
   We dont want to remove her current behavior. The programmer can not assume that the class after which he inherits behaves like this
   as otherwise, unless you have implemented it yourself, if only for the fact that in another java implementation (for example your colleague or client
   future) class can be implemented differently. For that whatever it was the behavior of the parent class was it
   saved, you must manually call the overloaded function at the right moment.
2. Btw - I wonder if without this line after covering To others, and to reveal it, magic would not become permanent. 2.
I assure you that the paintComponent method is called, but not  directly by the programmer.
*/
    }
}
