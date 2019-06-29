package com.data_structures_examples.linear;

public class Stack
{
    private int[] aray;
    private int top;
    private int capacity;

    public Stack(int size) {
        this.aray = new int[size];
        this.capacity = size;
        this.top = -1;
    }

    public void push(int number) {
        if (isFull()) {
            System.out.println("Stack is full.");
            System.exit(1);
        }

        System.out.println("Inserting " + number);
        aray[++top] = number;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            System.exit(1);
        }

        System.out.println("Removing " + peek());

        return aray[top--];
    }

    public int peek() {
        if (!isEmpty()) {
            return aray[top];
        } else {
            System.exit(1);
        }

        return -1;
    }

    public int size() {
        return top + 1;
    }

    private boolean isEmpty() {
        return top == -1;
    }

    private Boolean isFull() {
        return top == capacity - 1;
    }
}