package com.michaldabski.stacks.tests;

import com.michaldabski.stacks.TripleStack;
import junit.framework.TestCase;

/**
 * Created by Michal on 12/09/2015.
 */
public class TripleStackTest extends TestCase {
    TripleStack stack;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        stack = new TripleStack(15);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        stack = null;
    }

    public void testStackSize() throws Exception {
        // should allow maximum of 5 items in the stack

        stack.push(1, 0);
        stack.push(2, 0);
        stack.push(3, 0);
        stack.push(4, 0);
        stack.push(5, 0);

        try {
            stack.push(1, 0);
            fail("Did not raise error when stack is full");
        } catch (RuntimeException e) {
            assertEquals("Stack full: 0", e.getMessage());
        }

        assertEquals(5, stack.pop(0));
        assertEquals(4, stack.pop(0));

        stack.push(10, 0);
        stack.push(11, 0);
    }

    public void testMultipleStacks() throws Exception {
        stack.push(1, 0);
        stack.push(2, 0);
        stack.push(3, 0);
        stack.push(4, 0);
        stack.push(5, 0);

        stack.push(10, 1);
        stack.push(20, 1);
        stack.push(30, 1);
        stack.push(40, 1);
        stack.push(50, 1);

        stack.push(100, 2);
        stack.push(200, 2);
        stack.push(300, 2);
        stack.push(400, 2);
        stack.push(500, 2);


        assertEquals(5, stack.pop(0));
        assertEquals(50, stack.pop(1));
        assertEquals(500, stack.pop(2));

        assertEquals(4, stack.pop(0));
        assertEquals(40, stack.pop(1));
        assertEquals(400, stack.pop(2));
    }
}