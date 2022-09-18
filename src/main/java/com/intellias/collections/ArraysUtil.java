package com.intellias.collections;

public class ArraysUtil {
    private ArraysUtil() {
    }
    static final String ILLEGAL_CAPACITY_MESSAGE = "Illegal capacity: %d";
    static final String INDEX_OUT_OF_BOUNDS_MESSAGE = "Index: %d, size: %d";

    public static <T> T[] increaseCapacity(T[] array, int newCapacity) throws IllegalArgumentException {
        if (newCapacity < 0 || newCapacity < array.length) {
            throw new IllegalArgumentException(
                    String.format(ILLEGAL_CAPACITY_MESSAGE, newCapacity)
            );
        } else if (newCapacity == array.length) {
            return array;
        }

        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, array.length);
        return newArray;
    }

    public static <T> T[] decreaseCapacity(T[] array, int newCapacity) throws IllegalArgumentException {
        if (newCapacity < 0 || newCapacity > array.length) {
            throw new IllegalArgumentException(
                    String.format(ILLEGAL_CAPACITY_MESSAGE, newCapacity)
            );
        } else if (newCapacity == array.length) {
            return array;
        }

        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, newCapacity);
        return newArray;
    }
}
