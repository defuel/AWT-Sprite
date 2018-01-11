package framework;

import java.awt.*;

public class CustomLabel extends Component implements Updatable {
    Dimension dim;
    String str;
    Font font;

    public CustomLabel(String str, Font font) {
        this.str = str;
        this.font = font;
        setFont(font);
        FontMetrics fm = getFontMetrics(getFont());
        dim = new Dimension(fm.stringWidth(str) + 10, fm.getHeight() + 10);
        setSize(dim.width, dim.height);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint-label");

        g.setColor(Color.yellow);
        g.setFont(font);
        g.drawString(str, 5 , dim.height-10);
    }

    @Override
    public Dimension getPreferredSize() {
        return dim;
    }

    @Override
    public void update() {
        setLocation(getLocation().x, getLocation().y-1);
    }
}
