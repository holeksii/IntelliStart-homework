package com.intellias.hw8.shape3d;

import com.intellias.hw8.Area;
import com.intellias.hw8.Shape;
import com.intellias.hw8.Volume;

/**
 * Abstract class <code>Shape3D</code>
 * <p>
 *     <br>
 *     represents 3D shapes
 *     extends from <code>abstract class Shape</code>
 *     <br>
 *     implements <code>interface Area</code> and <code>interface Volume</code>
 *     <br>
 *     contains <code>abstract method getArea()</code> and <code>abstract method getVolume()</code>
 *     <br>
 * </p>
 * @author Oleksii Hytsiv
 */
public abstract class Shape3D
extends Shape
implements Area, Volume {
}
