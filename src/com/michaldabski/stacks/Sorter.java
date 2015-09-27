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

    public void sort() {
        final Stack<T> tmp = new Stack<T>();

        while (!isSorted()) {
            T value = null;
            while (!stack.empty()) {
                if (value == null) value = stack.pop();

                if (stack.isEmpty() || value.compareTo(stack.peek()) < 0) { // value smaller than the one on stack
                    tmp.push(value);
                    value = null;
                } else {
                    tmp.push(stack.pop());
                }
            }
            if (value != null) tmp.push(value);

            while (!tmp.isEmpty()) stack.push(tmp.pop());
        }

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
