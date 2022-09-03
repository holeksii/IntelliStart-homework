package com.intellias.hw8.shape2d;

import java.util.Objects;

/**
 * class that represents <code>Quad</code>
 * <p>
 *     extends from <code>abstract class Shape2D</code>
 * </p>
 * @author Oleksii Hytsiv
 */
public class Quad extends Shape2D {
    private final double sideA;
    private final double sideB;

    public Quad(double sideA, double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    @Override
    public String toString() {
        return String.format("Quad(sideA = %.2f, sideB = %.2f)", sideA, sideB);
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

        Quad quad = (Quad) o;

        return quad.sideA == sideA && quad.sideB == sideB;
    }

    @Override
    public double getArea() {
        return sideA * sideB;
    }

    @Override
    public double getPerimeter() {
        return 2 * (sideA + sideB);
    }
}
