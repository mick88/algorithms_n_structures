package com.michaldabski.stacks;

/**
 * Created by Michal on 12/09/2015.
 * <p/>
 * A stack containing three stacks in the same array
 */
public class TripleStack {
    final int[] array;
    // head position of each stack within the stack (from 0)
    final int[] heads = new int[3];

    int getStackStart(int stack) {
        return getStackSize() * stack;
    }

    int getStackSize() {
        return array.length / 3;
    }

    /**
     * Creates a new triple stack with given array size for all three stacks
     */
    public TripleStack(int size) {
        this.array = new int[size];
    }

    public void push(int value, int stack) {
        if (stack > 2) throw new ArrayIndexOutOfBoundsException("Stack number must be between 0 and 2");
        if (heads[stack] == getStackSize()) throw new RuntimeException("Stack full: " + stack);
        int index = getStackStart(stack) + heads[stack];
        array[index] = value;
        heads[stack]++;
    }

    public int pop(int stack) {
        if (stack > 2) throw new ArrayIndexOutOfBoundsException("Stack number must be between 0 and 2");
        if (heads[stack] == 0) throw new RuntimeException("Stack is empty: " + stack);
        heads[stack]--;
        int index = getStackStart(stack) + (heads[stack]);
        return array[(index)];
    }

    /**
     * Output stack contents with current HEAD positions in square braces
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(array.length * 4);
        for (int stack = 0; stack < 3; stack++) {
            int head = heads[stack];
            for (int i = 0; i < getStackSize(); i++) {
                int value = array[getStackStart(stack) + i];
                if (i == head) {
                    builder.append('[').append(value).append(']');
                } else {
                    builder.append(value);
                }
                builder.append(", ");
            }
            if (head == getStackSize()) builder.append("[]");
            builder.append('\n');
        }

        return builder.toString();
    }
}
