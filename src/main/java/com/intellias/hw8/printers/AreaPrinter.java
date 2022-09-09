package com.intellias.hw8.printers;

import com.intellias.hw8.HasArea;

public class AreaPrinter implements Printer<HasArea> {
    public void print(HasArea area) {
        System.out.println("area = " + area.getArea());
    }
}
