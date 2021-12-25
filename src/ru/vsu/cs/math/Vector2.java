package ru.vsu.cs.math;

public class Vector2 {
    private final double x;
    private final double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2 add(Vector2 other) {
        return new Vector2(x + other.x, y + other.y);
    }

    public Vector2 mul(double nb) {
        return new Vector2((x * nb), y * nb);
    }

    public Vector2 normalized() {
        double len = length();
        if (len < 1e-12)
            return new Vector2(0, 0);
        return new Vector2(x / len, y / len);
    }

    public double length() {
        return Math.sqrt(x*x + y*y);
    }
}
