package com.intellias.hw8.shape2d;

import com.intellias.hw8.Area;
import com.intellias.hw8.Perimeter;
import com.intellias.hw8.Shape;

/**
 * Abstract class <code>Shape2D</code>
 * <p>
 *     <br>
 *     represents 2D shapes
 *     extends from <code>abstract class Shape</code>
 *     <br>
 *     implements <code>interface Area</code> and <code>interface Perimeter</code>
 *     <br>
 *     contains <code>abstract method getArea()</code> and <code>abstract method getPerimeter()</code>
 *     <br>
 * </p>
 * @author Oleksii Hytsiv
 */
public abstract class Shape2D
extends Shape
implements Perimeter, Area {
}
