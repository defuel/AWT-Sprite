import framework.CustomFrame;
import framework.CustomPanel;
import framework.ImageCanvas;
import framework.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferedImage;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        SpriteSheet mapChip = new SpriteSheet("resources/images/fc_field.png", 16, 30, new Color(162, 126, 200));
        SpriteSheet character = new SpriteSheet("resources/images/fc_cha_04.png", 8, 12, new Color(128, 202, 196));

        Frame frame = new CustomFrame();
        frame.setTitle("TEST");
        frame.setSize(300, 300);

        CustomPanel panel = new CustomPanel();
        panel.setBackground(Color.black);
        panel.setSize(300, 300);
        panel.setLayout(null);
        frame.add(panel);

        int chara = (int)(Math.random() * 4.0f);
        List<BufferedImage> charaSprites = new ArrayList<>();
        charaSprites.add( character.getSprite(6, chara * 3));
        charaSprites.add( character.getSprite(6, chara * 3 + 1));
        charaSprites.add( character.getSprite(6, chara * 3 + 2));
        CharacterCanvas characterCanvas = new CharacterCanvas(32, 32, charaSprites.get(0), charaSprites);
        panel.add(characterCanvas);
        characterCanvas.setLocation(145 - characterCanvas.getWidth(), 140 - characterCanvas.getHeight());

        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if((int)(Math.random() * 4.0f) == 0){
                    BufferedImage image2 = mapChip.getSprite(8 + (int)(Math.random() * 8.0f), 18 + (int)(Math.random() * 12.0f));
                    ImageCanvas canvas2 = new MapCanvas(32, 32, image2);
                    panel.add(canvas2);
                    canvas2.setLocation(i*32, j*32);
                }
                BufferedImage image = mapChip.getSprite((int)(Math.random() * 16.0f), (int)(Math.random() * 18.0f));
                ImageCanvas canvas = new MapCanvas(32, 32, image);
                panel.add(canvas);
                canvas.setLocation(i*32, j*32);
            }
        }

        Thread thread = new Thread(panel);
        thread.start();

        frame.setVisible(true);
    }
}
