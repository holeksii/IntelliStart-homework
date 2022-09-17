package com.intellias.collections;

public class LinkedList<T> implements List<T> {
    private static final String INDEX_OUT_OF_BOUNDS_MESSAGE = "Index: %d, size: %d";
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    public void linkFirst(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void linkLast(T item) {
        Node<T> newNode = new Node<>(item);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> current = head;
        int index = 0;

        if (o == null) {
            return indexOfNull();
        } else {
            while (current != null) {
                if (o.equals(current.item)) {
                    return index;
                }
                current = current.next;
                index++;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(T item) {
        linkLast(item);
        return true;
    }

    public void add(int index, T item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format(INDEX_OUT_OF_BOUNDS_MESSAGE, index, size));
        }

        if (index == 0) {
            linkFirst(item);
        } else if (index == size) {
            linkLast(item);
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<T> newNode = new Node<>(item);
            newNode.next = current.next = newNode;
            size++;
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(String.format(INDEX_OUT_OF_BOUNDS_MESSAGE, index, size));
        }

        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        T item = current.item;
        current.next = current.next.next;
        size--;
        return item;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            int index = indexOfNull();
            if (index >= 0) {
                remove(index);
                return true;
            }
        } else {
            Node<T> current = head;
            while (current != null) {
                if (o.equals(current.item)) {
                    unlink(current);
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    private void unlink(Node<T> x) {
        if (x == head) {
            head = head.next;
        } else if (x.equals(tail)) {
            tail = tail.prev;
        } else {
            Node<T> current = head;
            while (current.next != x) {
                current = current.next;
            }
            current.next = x.next;
        }
        size--;
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
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(String.format(INDEX_OUT_OF_BOUNDS_MESSAGE, index, size));
        }

        Node<T> current;
        if (index <= size / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current.item;
    }

    private int indexOfNull() {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.item == null) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
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
