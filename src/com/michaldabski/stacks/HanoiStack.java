package com.michaldabski.stacks;

import java.util.Stack;

/**
 * A stack implementation which allows pushing only smaller element on the top of bigger elements
 */
public class HanoiStack extends Stack<Integer> {
    @Override
    public Integer push(Integer item) {
        if (!empty() && peek() <= item)
            throw new IllegalStateException(String.format("Cannot place element %d atop %d", item, peek()));
        return super.push(item);
    }
}
