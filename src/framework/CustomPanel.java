package framework;

import java.awt.*;

public class CustomPanel extends Panel implements Runnable{

    private Image offscreen;

    @Override
    public void update(Graphics g) {
        System.out.println("panel-update");
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("panel-paint");
        if(offscreen == null){
            offscreen = createImage(getWidth(), getHeight());
        }

        Graphics2D buffer = (Graphics2D)offscreen.getGraphics();
        buffer.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        buffer.setClip(0, 0, getWidth(), getHeight());
        super.paint(buffer);
        g.drawImage(offscreen, 0, 0, null);
        buffer.dispose();
    }

    @Override
    public void run() {
        while(true){
            for (Component component : getComponents()) {
                ((Updatable)component).update();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
