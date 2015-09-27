package com.michaldabski.stacks;

import java.util.Stack;

/**
 * Created by Michal on 27/09/2015.
 *
 * A stack which keeps track of lowest value in it
 *
 * How would you design a stack which, in addition to push and pop,
 * also has a function lowest which returns the minimum element?
 * Push, pop and lowest should all operate in O(1) time
 *
 * This implementation uses a separate stack to keep track of the lowest value.
 * The min value is popped from the extra stack if it's the same as value popped from main stack.
 * When pushing new value onto the main stack, it is also added to the extra stack if
 * it's smaller or same as the value at the top of it.
 *
 */
public class StackMin extends Stack<Integer> {
    final Stack<Integer> lowest;

    public StackMin() {
        this.lowest = new Stack<Integer>();
    }

    @Override
    public synchronized Integer pop() {
        Integer value = super.pop();
        if (value.equals(lowest.peek())) lowest.pop();
        return value;
    }

    @Override
    public Integer push(Integer item) {
        if (lowest.empty() || item <= lowest.peek())
            lowest.push(item);
        return super.push(item);
    }

    public Integer getMin() {
        if (lowest.empty()) return null;
        else return lowest.peek();
    }
}
