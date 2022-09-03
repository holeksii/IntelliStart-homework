package com.intellias.hw8.shape2d;

import java.util.Objects;

/**
 * class that represents <code>Circle</code>
 * <p>
 *     extends from <code>abstract class Shape2D</code>
 * </p>
 * @author Oleksii Hytsiv
 */
public class Circle extends Shape2D {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return String.format("Circle(radius = %.2f)", radius);
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
        if (!(o instanceof Circle)) {
            return false;
        }

        Circle circle = (Circle) o;

        return circle.radius == radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
