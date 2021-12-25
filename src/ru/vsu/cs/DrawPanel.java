package ru.vsu.cs;

import ru.vsu.cs.math.Rectangle;
import ru.vsu.cs.model.Field;
import ru.vsu.cs.model.World;
import ru.vsu.cs.timers.WorldTimer;
import ru.vsu.cs.utils2d.ScreenConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {
    private ScreenConverter screenConverter;
    private World world;
    private WorldTimer uwt;
    private Timer drawTimer;

    public DrawPanel() {
        super();
        Field f = new Field(
                new Rectangle(0, 10, 10, 10));
        world = new World();
        screenConverter = new ScreenConverter(f.getRectangle(), 450, 450);


//        (uwt = new UpdateWorldTimer(w, 1)).start();
//        drawTimer = new Timer();
//        drawTimer.start();
    }

    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        world.draw((Graphics2D)bi.getGraphics(), screenConverter);
        g.drawImage(bi, 0, 0, null);
    }

}
