package ru.vsu.cs.utils2d;

import java.awt.*;

public class DrawUtils {
    public static void drawWithColor(Graphics2D gr2d, Color color, Runnable drawAction) {
        Color oldC = gr2d.getColor();
        gr2d.setColor(color);
        drawAction.run();
        gr2d.setColor(oldC);
    }
}
