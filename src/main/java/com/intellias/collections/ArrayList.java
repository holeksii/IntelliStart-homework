package com.intellias.collections;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int SIZE_FACTOR = 2;
    private Object[] elements;
    private int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException(
                    String.format(ArraysUtil.ILLEGAL_CAPACITY_MESSAGE, capacity));
        }
        elements = new Object[capacity];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(T item) {
        add(size, item);
        return true;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    String.format(ArraysUtil.INDEX_OUT_OF_BOUNDS_MESSAGE, index, size));
        }
        if (size == elements.length) {
            elements = ArraysUtil.increaseCapacity(elements,
                    elements.length * SIZE_FACTOR);
        }

        System.arraycopy(elements, index, elements, index + 1, size - index);
        size++;
        elements[index] = item;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index >= 0) {
            remove(index);
            return true;
        }
        return false;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    String.format(ArraysUtil.INDEX_OUT_OF_BOUNDS_MESSAGE, index, size));
        }

        size--;
        System.arraycopy(elements, index + 1, elements, index, size - index);

        if (size < elements.length / SIZE_FACTOR) {
            elements = ArraysUtil.decreaseCapacity(elements,
                    Math.max(elements.length / SIZE_FACTOR, DEFAULT_CAPACITY));
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) elements[index];
    }
}
