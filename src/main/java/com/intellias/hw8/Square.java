package com.intellias.hw8;

/**
 * class that represents <code>Square</code>
 * <p>
 *     extends from <code>abstract class Shape</code>
 * </p>
 * @author Oleksii Hytsiv
 */
public class Square extends Shape {
    private final Quad quad;

    public Square(double sideA) {
        quad = new Quad(sideA, sideA);
    }

    public double getSideA() {
        return quad.getSideA();
    }

    @Override
    public String toString() {
        return String.format("Square(sideA = %.2f)", getSideA());
    }

    @Override
    public double getArea() {
        return quad.getSideA() * quad.getSideA();
    }

    @Override
    public double getPerimeter() {
        return quad.getSideA() * 4;
    }
}
