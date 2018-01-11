package framework;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageCanvas extends Component implements Updatable {
    Dimension dimension;
    BufferedImage image;
    AffineTransform trans;

    private ImageCanvas(int width, int height){
        setSize(width, height);
        dimension = new Dimension(width, height);
    }

    public ImageCanvas(int width, int height, BufferedImage image){
        this(width, height);
        this.image = image;
        rescaleImage();
    }

    public ImageCanvas(int width, int height, String imagePath) {
        this(width, height);
        try {
            URL url = this.getClass().getResource(imagePath);
            image = ImageIO.read(url);
            rescaleImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Graphics g) {
        System.out.println("update-canvas");
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        System.out.println("paint-canvas");
        g2.drawImage(image, trans, this);

    }

    @Override
    public Dimension getPreferredSize() {
        return dimension;
    }

    public void setImage(BufferedImage image){
        this.image = image;
    }

    @Override
    public void update() {

    }

    private void rescaleImage(){
        double sx = (double) getWidth() / image.getWidth();
        double sy = (double) getHeight() / image.getHeight();
        trans = AffineTransform.getScaleInstance(sx, sy);
    }
}
