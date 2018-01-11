import framework.ImageCanvas;

import java.awt.image.BufferedImage;

public class MapCanvas extends ImageCanvas {

    private int count = 0;
    private int direction = 0;

    public MapCanvas(int width, int height, BufferedImage image) {
        super(width, height, image);
    }

    @Override
    public void update() {
        switch (direction){
            case 0:
                setLocation(getLocation().x-1, getLocation().y);
                break;
            case 1:
                setLocation(getLocation().x, getLocation().y-1);
                break;
            case 2:
                setLocation(getLocation().x+1, getLocation().y);
                break;
            case 3:
                setLocation(getLocation().x, getLocation().y+1);
                break;
        }
        count++;
        if(count >= 52){
            count = 0;
            direction++;
            if(direction >= 4){
                direction = 0;
            }
        }
    }
}
