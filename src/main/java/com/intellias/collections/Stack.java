package com.intellias.collections;

public class Stack<T> implements Dequeue<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int SIZE_FACTOR = 2;
    private Object[] elements;
    private int size;

    public Stack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return true;
                }
            }
        }

        return false;
    }

    public void push(T item) {
        add(item);
    }

    @Override
    public boolean add(T item) {
        if (size == elements.length) {
            elements = ArraysUtil.increaseCapacity(elements,
                    size * SIZE_FACTOR);
        }
        elements[size++] = item;
        return true;
    }

    public T pop() {
        T item = peek();
        remove(size - 1);
        return item;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    String.format(ArraysUtil.INDEX_OUT_OF_BOUNDS_MESSAGE, index, size)
            );
        }
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        if (size < elements.length / SIZE_FACTOR) {
            elements = ArraysUtil.decreaseCapacity(elements,
                    elements.length / SIZE_FACTOR);
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            return null;
        }
        return (T) elements[size - 1];
    }
}
