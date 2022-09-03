package com.intellias.hw8;

/**
 * Abstract class <code>Shape</code>
 * <p>
 *     <br>
 *     represents shapes
 *     <br>
 *     contains <code>abstract method toString()</code>
 *     <br>
 *     contains <code>abstract method hashCode()</code>
 *     <br>
 *     contains <code>abstract method equals(Object o)</code>
 * </p>
 * @author Oleksii Hytsiv
 */
public abstract class Shape {
    @Override
    public abstract String toString();

    @Override
    public abstract int hashCode();

    @Override
    public abstract boolean equals(Object obj);
}
