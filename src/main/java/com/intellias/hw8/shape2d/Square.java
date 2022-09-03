package com.intellias.hw8.shape2d;

import java.util.Objects;

/**
 * class that represents <code>Square</code>
 * <p>
 *     extends from <code>abstract class Shape2D</code>
 * </p>
 * @author Oleksii Hytsiv
 */
public class Square extends Shape2D {
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
    public int hashCode() {
        return Objects.hashCode(this);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Quad)) {
            return false;
        }

        Square square = (Square) o;

        return square.quad.getSideA() == quad.getSideA();
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
