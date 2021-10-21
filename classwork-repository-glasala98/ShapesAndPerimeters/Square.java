package com.sg.foundations.ShapesAndPerimeters;

public class Square extends Shape {
    private final double length;
    public Square() {
        this(1);
    }

    public Square(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return length * length;
    }

    @Override
    public double getPerimeter() {
        return 4 * length;
    }
}
