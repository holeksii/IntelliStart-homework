package com.intellias.hw8.printers;

import com.intellias.hw8.HasPerimeter;

public class PerimeterPrinter implements Printer<HasPerimeter> {
    public void print(HasPerimeter perimeter) {
        System.out.println("perimeter = " + perimeter.getPerimeter());
    }
}
