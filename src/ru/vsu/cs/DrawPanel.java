package ru.vsu.cs;

import ru.vsu.cs.model.Bonfire;
import ru.vsu.cs.model.World;
import ru.vsu.cs.timers.WorldTimer;
import ru.vsu.cs.timers.WorldTimerBase;
import ru.vsu.cs.utils2d.ScreenConverter;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DrawPanel extends JPanel {
    private ScreenConverter screenConverter;
    private World world;
    private WorldTimerBase worldTimer;
    private Timer drawTimer;

    public DrawPanel() {
        super();
        Bonfire bonfire = new Bonfire(500, 300);
        world = new World(bonfire);
        screenConverter = new ScreenConverter(
                0,
                0,
                bonfire.getFireWidth(),
                bonfire.getFireHeight(),
                400,
                500
        );


        (worldTimer = new WorldTimer(world, 10)).start();
        drawTimer = new Timer(10, (e) -> this.repaint());
        drawTimer.start();
    }

    @Override
    public void paint(Graphics g) {
        screenConverter.setwScreen(this.getWidth());
        screenConverter.sethScreen(this.getHeight());


        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        world.draw((Graphics2D)bi.getGraphics(), screenConverter);
        g.drawImage(bi, 0, 0, null);
    }

    public void restartBonfire() {
        this.world.restartBonfire();
    }

    public void setDecayRate(float fireRate) {
        this.world.setBonfireDecayRate(fireRate);
    }

    public void setKeepFireRate(float keepFireRate) {
        this.world.setBonfireKeepFireRate(keepFireRate);
    }
}
