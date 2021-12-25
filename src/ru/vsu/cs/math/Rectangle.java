package ru.vsu.cs.math;

public class Rectangle {
    private final double left;
    private final double top;
    private final double width;
    private final double height;


    public Rectangle(Vector2 topLeft, Vector2 bottomRight) {
        this(
                Math.min(topLeft.getX(), bottomRight.getX()),
                Math.max(topLeft.getY(), bottomRight.getY()),
                Math.abs(topLeft.getX() - bottomRight.getX()),
                Math.abs(topLeft.getY() - bottomRight.getY())
        );
    }

    public Rectangle(double left, double top, double width, double height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public double getBottom() {
        return top - height;
    }

    public double getLeft() {
        return left;
    }

    public double getRight() {
        return left + width;
    }

    public double getTop() {
        return top;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public boolean isInside(Vector2 p) {
        return getLeft() < p.getX() && p.getX() < getRight() && getBottom() < p.getY() && p.getY() < getTop();
    }

    public Vector2 getCenter() {
        return new Vector2((getLeft() + getRight()) * 0.5, (getTop() + getBottom()) * 0.5);
    }

    public Vector2 getSize() {
        return new Vector2(getWidth(), getHeight());
    }

    public Vector2 getTopLeft() {
        return new Vector2(left, top);
    }

    public Vector2 getBottomRight() {
        return new Vector2(left + width, top - height);
    }
}
