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
//        int width = screenConverter.realToScreenDistanceAlongX(this.bonfire.getFireWidth() * (screenConverter.getwScreen() / screenConverter.getwReal()));
//        int height = screenConverter.realToScreenDistanceAlongX(this.bonfire.getFireHeight() * (screenConverter.gethScreen() / screenConverter.gethReal()));

        int width = screenConverter.realToScreenDistanceAlongX(this.bonfire.getFireWidth());
        int height = screenConverter.realToScreenDistanceAlongY(this.bonfire.getFireHeight());

//        System.out.printf(" w %d h %d \n", width, height);

        int screenChunkSizeX = (int) (screenConverter.getwScreen() / screenConverter.getwReal());
        int screenChunkSizeY = (int) (screenConverter.gethScreen() / screenConverter.gethReal());

//        int screenChunkSizeX = (int) Math.ceil(screenConverter.getwScreen() / screenConverter.getwReal());
//        int screenChunkSizeY = (int) Math.ceil(screenConverter.gethScreen() / screenConverter.gethReal());

//        System.out.printf(" w %d h %d \n", screenChunkSizeX, screenChunkSizeY);
        gr2d.setColor(Color.BLUE);
        gr2d.fillRect(topLeftPoint.getX(), topLeftPoint.getY(), width, height);

        int fireWidth = this.bonfire.getFireWidth();
        int fireHeight = this.bonfire.getFireHeight();



//        int realRowLeft = fireHeight;
//        int screenRowLeft = screenConverter.gethScreen();
        for (int row = 0; row < fireHeight; row++) {
//            int realColLeft = fireWidth;
//            int screenColLeft = screenConverter.getwScreen();
//
//            int screenChunkSizeY = (int) Math.ceil(screenRowLeft / (float) realRowLeft);
//            screenRowLeft -= screenChunkSizeY;
//            realRowLeft -= 1;

            for (int column = 0; column < fireWidth; column++) {

                int chunkIdx = column + (fireWidth * row);
                int fireIntensity = bonfire.getFireTempArray()[chunkIdx];

//                int finalColumn = column;
//                int finalRow = row;
//                DrawUtils.drawWithColor(gr2d, ColorPalette.colorPalette[fireIntensity], () -> {

//                int screenChunkSizeX = (int) Math.ceil(screenColLeft / (float) realColLeft);
//                screenColLeft -= screenChunkSizeX;
//                realColLeft -= 1;



//                int screenChunkSizeX =

//                Color oldC = gr2d.getColor();
//                gr2d.setColor(ColorPalette.colorPalette[fireIntensity]);
                int finalColumn = column;
                int finalRow = row;
                DrawUtils.drawWithColor(gr2d, ColorPalette.colorPalette[fireIntensity], () -> {
                    gr2d.fillRect(finalColumn * screenChunkSizeX, finalRow * screenChunkSizeY, screenChunkSizeX, screenChunkSizeY);
                });


//                gr2d.setColor(oldC);
//                });

            }
        }
    }
}
