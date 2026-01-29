package org.postfix;

import java.util.ArrayList;

public class StackVector<T> implements Stack<T> {
    private ArrayList<T> items;
    private int top = 0;
    
    public StackVector() {
        this.items = new ArrayList<T>();
    }

    @Override
    public void push(T item) {
        items.add(item);
        top++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        top--;
        T item = items.get(top);
        items.remove(top);
        return item;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.get(top - 1);
    }
    
    public boolean isEmpty() {
        return top == 0;
    }
    
    public int size() {
        return top;
    }
}