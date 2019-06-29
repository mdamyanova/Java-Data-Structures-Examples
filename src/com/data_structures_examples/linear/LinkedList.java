package com.data_structures_examples.linear;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private Node head;
    private Node tail;
    private int count;

    public int size() {
        return this.count;
    }

    private void setCount(int count) {
        this.count = count;
    }

    public void addFirst(T item) {
        Node newNode = new Node(item);

        if (this.count == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;
        }

        this.count++;
    }

    public void addLast(T item) {
        Node newNode = new Node(item);

        if (this.count == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }

        this.count++;
    }

    public T removeFirst() {
        if (this.count == 0) {
            throw new IllegalArgumentException();
        }

        T element = this.head.value;

        if (this.count == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
        }

        this.count--;
        return element;
    }

    public T removeLast() {
        if (this.count == 0) {
            throw new IllegalArgumentException();
        }

        T element = this.tail.value;

        if (this.count == 1) {
            this.head = null;
            this.tail = null;
        } else {
            Node current = this.head;

            while (current.next != this.tail) {
                current = current.next;
            }
            current.next = null;
            this.tail = current;
        }

        this.count--;
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node current;

        private LinkedListIterator() {
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            return this.current == tail;
        }

        @Override
        public T next() {
            T value = this.current.value;
            this.current = this.current.next;
            return value;
        }
    }

    private class Node {
        private T value;
        private Node next;

        public Node(T value) {
            this.value = value;
        }
    }
}