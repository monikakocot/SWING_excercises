package pictureExcercise;

/*
A program that displays two images side by side,
one saved on your hard drive, the other downloaded from any URL.

- Downloading a picture from the web - in the absence of an internet connection, or incorrect image URL
   an exception will be thrown and the application will not start because the panel will not be initialized.
- Save the image to disk.
- Display both images directly next to each other.

 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panel extends JPanel {

    private BufferedImage diskImage;
    private BufferedImage netImage;

    private int panelWidth;
    private int panelHeight;

    public Panel() {
        super();


            // the file from the disk will be the file saved from the URL.
        try {
            // create a URL object with an image path
            URL imageURL = new URL("https://thumbs.dreamstime.com/z/gitara-obrazek-57452710.jpg");
             //reading the image from the URL
            netImage = ImageIO.read(imageURL);

            // creating a new file on the disk
            File imageFile2 = new File("java2.jpg");
            // saving the image to a file
            ImageIO.write(netImage, "png", imageFile2);
            //loading an image from a file
            File imageFile = new File("java.jpg");
            diskImage = ImageIO.read(imageFile);

        } catch (IOException e) {
            System.err.println("Error with reading a picture");
            e.printStackTrace();
        }

        panelWidth = diskImage.getWidth()*2;
        panelHeight = diskImage.getHeight();
        Dimension dimension = new Dimension(panelWidth, panelHeight);
        setPreferredSize(dimension);
    }

    /*

// withour saving picture from URL adress on disc
        try {
            //create a URL object with an image path
            URL imageURL = new URL("https://thumbs.dreamstime.com/z/gitara-obrazek-57452710.jpg");
            //reading the image from the URL
            netImage = ImageIO.read(imageURL);

            File imageFile = new File("java.jpg");
            diskImage = ImageIO.read(imageFile);

        } catch (IOException e) {
            System.err.println("Error with reading a picture");
            e.printStackTrace();
        }

*/

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        // 'draw' the image from the disk
        g2d.drawImage(diskImage, 0, 0, this);

        // 'draw' the image from URL adress
        g2d.drawImage(netImage, diskImage.getWidth(), 0, null);
    }
}
