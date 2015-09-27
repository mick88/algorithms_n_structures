package com.michaldabski.stacks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michal on 27/09/2015.
 * <p/>
 * A stack built upon smaller stacks of predetermined size
 * <p/>
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks,
 * and should create a new stack once the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop()
 * should behave identically to a single stack (that is, pop() should return the same values as it would
 * if there were just a single stack).
 * <p/>
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 * <p/>
 * This implementation uses an ArrayList to store the collection of stacks, and a single head value.
 */
public class SetOfStacks {
    private static class StackNode {
        final int[] values;

        private StackNode(int size) {
            this.values = new int[size];
        }
    }

    final List<StackNode> stackNodes;
    final int stackSize;
    int head = 0;

    /**
     * Gets node at specified position.
     * Creates new node if needed, but only one at atime
     */
    private StackNode getStackNodeAt(int position) {
        if (position == stackNodes.size()) {
            stackNodes.add(new StackNode(stackSize));
        }
        return stackNodes.get(position);
    }

    public SetOfStacks(int stackSize) {
        this.stackSize = stackSize;
        stackNodes = new ArrayList<StackNode>(1);
    }

    public void push(int value) {
        final StackNode node = getStackNodeAt(head / stackSize);
        node.values[head % stackSize] = value;
        head++;
    }

    public int pop() {
        head--;
        int position = head / stackSize;
        final StackNode node = getStackNodeAt(position);

        // remove stack if no longer needed
        if (position < stackNodes.size() - 1) {
            stackNodes.remove(position + 1);
        }

        return node.values[head % stackSize];
    }
}
