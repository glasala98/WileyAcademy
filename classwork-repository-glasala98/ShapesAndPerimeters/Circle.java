package com.sg.foundations.ShapesAndPerimeters;

public class Circle extends Shape{
    private final double radius;
    final double pi = Math.PI;

    public Circle() {
        this(1);
    }
    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return pi * Math.pow(radius,2);
    }

    @Override
    public double getPerimeter() {
        return 2 * pi * radius;
    }
}
