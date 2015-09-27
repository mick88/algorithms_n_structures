package com.michaldabski.stacks;

import java.util.Stack;

/**
 * Created by Michal on 27/09/2015.
 * <p/>
 * Class for sorting a stack using another stack in ascending order (highest number at the bottom)
 */
public class Sorter<T extends Comparable<T>> {
    final Stack<T> stack;

    public Sorter(Stack<T> stack) {
        this.stack = stack;
    }

    private void sortRecursively() {
        if (stack.size() < 2) return;

        T value = stack.pop();
        sort();

        if (value.compareTo(stack.peek()) > 0) {
            final T tmp = value;
            value = stack.pop();
            stack.push(tmp);
        }
        stack.push(value);
    }

    public void sort() {
        while (!isSorted())
            sortRecursively();
    }

    public boolean isSorted() {
        if (stack.isEmpty()) return true;
        else {
            final T value = stack.pop();
            try {
                return stack.isEmpty() || (value.compareTo(stack.peek()) <= 0 && isSorted());
            } finally {
                stack.push(value);
            }
        }
    }
}
