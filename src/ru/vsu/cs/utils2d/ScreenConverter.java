package ru.vsu.cs.utils2d;

import ru.vsu.cs.math.Rectangle;
import ru.vsu.cs.math.Vector2;

public class ScreenConverter {
    private double xReal;
    private double yReal;
    private double wReal;
    private double hReal;

    private int wScreen;
    private int hScreen;


    public ScreenConverter(double xReal, double yReal, double wReal, double hReal, int wScreen, int hScreen) {
        this.xReal = xReal;
        this.yReal = yReal;
        this.wReal = wReal;
        this.hReal = hReal;
        this.wScreen = wScreen;
        this.hScreen = hScreen;
    }

    public ScreenConverter(Rectangle real, int width, int height) {
        this(real.getLeft(), real.getHeight(), real.getWidth(), real.getHeight(), width, height);
    }


    public ScreenPoint realToScreen(Vector2 point) {
        int i = (int)((point.getX() - xReal) * wScreen / wReal);
        int j = (int)((yReal - point.getY()) * hScreen / hReal);
        return new ScreenPoint(i, j);
    }


    public Vector2 screenToReal(ScreenPoint point) {
        double x = xReal + point.getX() * wReal / wScreen;
        double y = yReal - point.getX() * hReal / hScreen;
        return new Vector2(x, y);
    }


    public int realToScreenDistanceAlongX(double xDistance) {
        return realToScreen(new Vector2(xDistance, 0)).getX() - realToScreen(new Vector2(0, 0)).getX();
    }


    public int realToScreenDistanceAlongY(double yDistance) {
        return realToScreen(new Vector2(0, 0)).getY() - realToScreen(new Vector2(0, yDistance)).getY();
    }

    public double gethReal() {
        return hReal;
    }

    public void sethReal(double hReal) {
        this.hReal = hReal;
    }

    public int gethScreen() {
        return hScreen;
    }

    public void sethScreen(int hScreen) {
        this.hScreen = hScreen;
    }

    public double getwReal() {
        return wReal;
    }

    public void setwReal(double wReal) {
        this.wReal = wReal;
    }

    public int getwScreen() {
        return wScreen;
    }

    public void setwScreen(int wScreen) {
        this.wScreen = wScreen;
    }

    public double getxReal() {
        return xReal;
    }

    public void setxReal(double xReal) {
        this.xReal = xReal;
    }

    public double getyReal() {
        return yReal;
    }

    public void setyReal(double yReal) {
        this.yReal = yReal;
    }




}
