package mouseExcercise;

// Any idea why removing and moving the square dont work ?

/*
In addition, the ability to remove the drawn shapes with the right mouse button.
And also the ability to move previously drawn shapes.
*/
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.JPanel;


public class MouseTestPanel2 extends JPanel implements MouseListener,
        MouseMotionListener {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    //Point that will remember the coordinates of moving the square
    Point movingPoint;
    ArrayList<Point> points = new ArrayList();

    public MouseTestPanel2() {

        addMouseListener(this);
        addMouseMotionListener(this);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
/*
First, we need to recognize if the user wants to draw or remove some square from the board.
To do this, we need to add a condition to check which mouse button has been pressed. This information is in the object
MouseEvent passed to each mouse method, and you can get to it by calling the getButton () method on the object.
It will give us a number of total type, we do not have to worry about whether it will be 1, 5 or 500, because the MouseEvent class has
BUTTON1, BUTTON2, and BUTTON3 constants are also defined for this purpose, only with a larger number of buttons is the problem a problem.
Removal itself is quite simple. In the list, we store the data of the top left corner of each drawn shape.
You should therefore search for one of them, which has the logical product of four conditions (all 4 conditions must be present):

1,2 - the X coordinate of the place where you clicked must be greater than the X coordinate of the upper left point of the square, and
      less than this value increased by 10.
3.4 - in the same way as in the case of X (remember that the Y coordinates increase down (the upper left corner of the screen is the point (0, 0).

We then remove the found point from the collection and refresh the panel using repaint ().
*/

    @Override
    public void mousePressed(MouseEvent e) {

        // coordinates in which you clicked
        int x1 = e.getX();
        int y1 = e.getY();

        // coordinates of squares
        int x2, y2;
        Point toRemove = null;
        // do we want to add, delete or move square
        // if the action taken is equal to BUTTON3 (right mouse)
        //if (e.getButton() == MouseEvent.BUTTON3){
        if (e.getButton() == 3){
            System.out.print(e.getButton());
            // condition for delete
            for (Point p : points) {

                // we assign x2, y2 as points of the squares (upper left corners)
                x2 = (int) p.getX();
                y2 = (int) p.getY();
                if (x1 >= x2 && y1 <=y2 && x1 <= x2 + 10 && y1 >= y2 - 10)
                    toRemove = p;
                // delete squares
                points.remove(toRemove);

            }
            points.remove(toRemove);
            repaint();

            // condition for move square
        } //else if (e.getButton() != MouseEvent.BUTTON1){
           else if (e.getButton() != 1) {
            int index = 0;
            int size = points.size();
            Point p;
            while (movingPoint == null && index < size) {
                p = points.get(index);
                x2 = (int) p.getX();
                y2 = (int) p.getY();
                if (x1 >= x2 && y1 >= y2 && x1 <= x2 + 10 && y1 <= y2 + 10)
                    movingPoint = p;
                index++;
            }

        }
        // if you have not clicked on any square - we draw a new square
        if (movingPoint==null && e.getButton() == MouseEvent.BUTTON1) {
            x1 = e.getX();
            y1 = e.getY();
            // add square
            points.add(new Point(x1, y1));

        }
        repaint(); // refresh the drawing panel
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (movingPoint != null) {
            movingPoint.x = e.getX();
            movingPoint.y = e.getY();
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        movingPoint = null;
    }

    // methods below witout changes
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, WIDTH, HEIGHT);

        drawRectangles(g2d);
    }

    // method for drwa aquares
    private void drawRectangles(Graphics2D g2d) {
        int x, y;
        for (Point p : points) {
            x = (int) p.getX();
            y = (int) p.getY();
            g2d.setColor(Color.BLACK);
            g2d.fillRect(x, y, 10, 10);
        }
    }
}
