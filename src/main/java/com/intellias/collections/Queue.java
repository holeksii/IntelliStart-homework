package com.intellias.collections;

public class Queue<T> implements Dequeue<T> {
    Node<T> head;
    Node<T> tail;
    int size;

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
            Node<T> current = head;
            while (current != null) {
                if (current.item == null) {
                    return true;
                }
                current = current.next;
            }
        } else {
            Node<T> current = head;
            while (current != null) {
                if (o.equals(current.item)) {
                    return true;
                }
                current = current.next;
            }
        }

        return false;
    }

    @Override
    public boolean add(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
        return true;
    }

    public T poll() {
        T item = peek();
        remove(0);
        return item;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    String.format(ArraysUtil.INDEX_OUT_OF_BOUNDS_MESSAGE, index, size));
        }

        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
        return true;
    }

    @Override
    public void clear() {
        Node<T> current = head;
        while (current != null) {
            Node<T> next = current.next;
            current.item = null;
            current.next = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public T peek() {
        return head.item;
    }

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        Node(T element, Node<T> prev, Node<T> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        Node(T element) {
            this(element, null, null);
        }
    }
}
