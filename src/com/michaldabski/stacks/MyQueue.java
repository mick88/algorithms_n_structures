package com.michaldabski.stacks;

import java.util.Queue;
import java.util.Stack;

/**
 * Created by Michal on 27/09/2015.
 * <p/>
 * A queue implemented using stacks
 * <p/>
 * This solution uses an auxiliary members stack which is not used outside dequeue().
 * <p/>
 * items are moved to aux stack to access the front of the queue and are not moved back to the main stack until needed
 * in enqueue() to optimize for multiple calls to dequeue()
 */
public class MyQueue<T> {
    public final Stack<T> stack;
    public final Stack<T> auxStack;

    public MyQueue() {
        this.stack = new Stack<T>();
        this.auxStack = new Stack<T>();
    }

    /**
     * Add element to the queue
     */
    public void enqueue(T element) {
        // move items back to the main stack if needed
        while (!auxStack.empty())
            stack.push(auxStack.pop());

        stack.push(element);
    }

    /**
     * Get element from the front of the queue
     */
    public T dequeue() {
        while (!stack.empty())
            auxStack.push(stack.pop());

        return auxStack.pop();
    }

    public int size() {
        return stack.size() + auxStack.size();
    }
}
