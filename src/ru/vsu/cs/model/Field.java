package ru.vsu.cs.model;

import ru.vsu.cs.math.Rectangle;

public class Field {
    private Rectangle rectangle;

    public Field(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }
}
