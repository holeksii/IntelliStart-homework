package com.intellias.hw8.printers;

import com.intellias.hw8.shapes.Shape;

public class ShapePrinter implements Printer<Shape> {
    public void print(Shape shape) {
        System.out.println(shape);
    }
}
