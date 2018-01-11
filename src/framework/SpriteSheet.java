package framework;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpriteSheet {

    List<List<BufferedImage>> spriteList;

    private String imagePath;
    private int row;
    private int cols;

    public SpriteSheet(String imagePath, int row, int cols, Color clearColor){
        try {
            BufferedImage org = ImageIO.read(this.getClass().getClassLoader().getResource(imagePath));
            BufferedImage dst = new BufferedImage(org.getWidth(), org.getHeight(), BufferedImage.TYPE_INT_ARGB);
            for (int y = 0; y < org.getHeight(); y++) {
                for (int x = 0; x < org.getWidth(); x++) {
                    if (org.getRGB(x, y) == clearColor.getRGB()){
                        dst.setRGB(x, y, 0);
                    } else {
                        dst.setRGB(x, y, org.getRGB(x, y));
                    }
                }
            }

            int x = 0;
            int y = 0;
            int width = dst.getWidth() / cols;
            int height = dst.getHeight() / row;
            spriteList = new ArrayList<>();
            for(int i = 0; i < row; i++){
                List<BufferedImage> colsList = new ArrayList<>();
                x = 0;
                for(int j = 0; j < cols; j++){
                    colsList.add(dst.getSubimage(x, y, width, height));
                    x += width;
                }
                spriteList.add(colsList);
                y += height;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite(int row, int cols){
        return spriteList.get(row).get(cols);
    }
}
