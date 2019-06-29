package com.data_structures_examples.linear;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> extends AbstractQueue<T> {
    private LinkedList<T> elements;

    public Queue() {
        this.elements = new LinkedList<>();
    }
    public Iterator<T> iterator() {
        return this.elements.iterator();
    }

    public int size() {
        return this.elements.size();
    }

    public boolean offer(T t) {
        if(t == null) {
            return false;
        }

        this.elements.addLast(t);
        return true;
    }

    public T poll() {
        Iterator<T> iter = this.elements.iterator();
        T t = iter.next();

        if(t != null){
            iter.remove();
            return t;
        }

        return null;
    }

    @Override
    public T peek() {
        return elements.getFirst();
    }
}