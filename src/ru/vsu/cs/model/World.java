package ru.vsu.cs.model;

import ru.vsu.cs.utils2d.ColorPalette;
import ru.vsu.cs.utils2d.DrawUtils;
import ru.vsu.cs.utils2d.ScreenConverter;
import ru.vsu.cs.utils2d.ScreenPoint;

import java.awt.*;

public class World {
    private Bonfire bonfire;

    public World(Bonfire bonfire) {
        this.bonfire = bonfire;
    }

    public void update() {
        this.bonfire.calculateFirePropagation();
    }

    public void draw(Graphics2D gr2d, ScreenConverter screenConverter) {
        ScreenPoint topLeftPoint = new ScreenPoint(0, 0);

        int width = screenConverter.realToScreenDistanceAlongX(this.bonfire.getFireWidth());
        int height = screenConverter.realToScreenDistanceAlongY(this.bonfire.getFireHeight());


        int screenChunkSizeX = (int) (screenConverter.getwScreen() / screenConverter.getwReal());
        int screenChunkSizeY = (int) (screenConverter.gethScreen() / screenConverter.gethReal());

        gr2d.setColor(Color.BLACK);
        gr2d.fillRect(topLeftPoint.getX(), topLeftPoint.getY(), width, height);

        int fireWidth = this.bonfire.getFireWidth();
        int fireHeight = this.bonfire.getFireHeight();

        for (int row = 0; row < fireHeight; row++) {


            for (int column = 0; column < fireWidth; column++) {

                int chunkIdx = column + (fireWidth * row);
                int fireIntensity = bonfire.getFireTempArray()[chunkIdx];

                int finalColumn = column;
                int finalRow = row;
                DrawUtils.drawWithColor(gr2d, ColorPalette.colorPalette[fireIntensity], () -> {
                    gr2d.fillRect(finalColumn * screenChunkSizeX, finalRow * screenChunkSizeY, screenChunkSizeX, screenChunkSizeY);
                });


            }
        }
    }

    public void restartBonfire() {
        this.bonfire.resetFire();
    }

    public void setBonfireDecayRate(float fireRate) {
        this.bonfire.setDecayRateMultiplier(fireRate);
    }

    public void setBonfireKeepFireRate(float keepFireRate) {
        this.bonfire.setKeepingFireRate(keepFireRate);
    }
}
