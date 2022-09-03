package com.intellias.hw8.shape2d;

import java.util.Objects;

/**
 * class that represents <code>Triangle</code>
 * <p>
 *     extends from <code>abstract class Shape2D</code>
 * </p>
 * @author Oleksii Hytsiv
 */
public class Triangle extends Shape2D {
    private final double sideA;
    private final double sideB;
    private final double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public String toString() {
        return String.format("Triangle(sideA = %.2f, sideB = %.2f, sideC = %.2f)", sideA, sideB, sideC);
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
        if (!(o instanceof Triangle)) {
            return false;
        }

        Triangle triangle = (Triangle) o;

        return triangle.sideA == sideA && triangle.sideB == sideB && triangle.sideC == sideC;
    }

    @Override
    public double getArea() {
        double halfPerimeter = this.getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - sideA) * (halfPerimeter - sideB) * (halfPerimeter - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }
}
