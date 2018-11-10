package mixExcercise;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PicturePanel extends JPanel {

    private BufferedImage image;

    public PicturePanel() {
        super();

        setPreferredSize(new Dimension(500, 200));
        File imageFile = new File("java.jpg");
        try {
            image = ImageIO.read(imageFile);

        } catch (IOException e) {
            System.err.println("ERROR WITH READING PICTURE");
            e.printStackTrace();
        }
        //Dimension dimension = new Dimension(image.getWidth(), image.getHeight());

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(image, 0, 0,500,200, this);
    }
}