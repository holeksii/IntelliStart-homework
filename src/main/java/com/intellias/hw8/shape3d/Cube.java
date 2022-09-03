package com.intellias.hw8.shape3d;

import java.util.Objects;

/**
 * class that represents <code>Cube</code>
 * <p>
 *     extends from <code>abstract class Shape3D</code>
 * </p>
 * @author Oleksii Hytsiv
 */
public class Cube extends Shape3D {
    private final double side;

    public Cube(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public String toString() {
        return String.format("Cube(side = %.2f)", side);
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
        if (!(o instanceof Cube)) {
            return false;
        }

        Cube cube = (Cube) o;

        return cube.side == side;
    }

    @Override
    public double getArea() {
        return 6 * side * side;
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }
}
