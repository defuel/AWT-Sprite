import framework.ImageCanvas;
import framework.SpriteSheet;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class CharacterCanvas extends ImageCanvas {

    private List<BufferedImage> sprites;
    int count = 0;

    public CharacterCanvas(int width, int height, BufferedImage image, List<BufferedImage> sprites) {
        super(width, height, image);

        this.sprites = sprites;
    }

    @Override
    public void update() {
        setImage(sprites.get(count));
        count++;
        if(count >= sprites.size()){
            count = 0;
        }
    }
}
