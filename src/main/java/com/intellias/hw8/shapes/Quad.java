package com.intellias.hw8.shapes;

public class Quad extends Shape {
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
    public double getArea() {
        return sideA * sideB;
    }

    @Override
    public double getPerimeter() {
        return 2 * (sideA + sideB);
    }
}
