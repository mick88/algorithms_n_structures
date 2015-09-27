package com.michaldabski.stacks;

import junit.framework.TestCase;

/**
 * Created by Michal on 27/09/2015.
 */
public class StackMinTest extends TestCase {
    StackMin stack;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        stack = new StackMin();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        stack = null;
    }

    public void testMinEmpty() throws Exception {
        assertTrue(stack.isEmpty());
        assertNull(stack.getMin());
    }

    public void testMin3() throws Exception {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        assertEquals(stack.size(), 3);
        assertEquals(stack.getMin(), new Integer(1));
    }

    public void testMin3reverse() throws Exception {
        stack.push(3);
        stack.push(2);
        stack.push(1);

        assertEquals(stack.size(), 3);
        assertEquals(stack.getMin(), new Integer(1));
    }

    public void testMin3Remove() throws Exception {
        stack.push(3);
        stack.push(2);
        stack.push(1);

        stack.pop();

        assertEquals(stack.size(), 2);
        assertEquals(stack.getMin(), new Integer(2));
    }

    public void testMin3RemoveDuplicate() throws Exception {
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(1);

        stack.pop();

        assertEquals(stack.size(), 3);
        assertEquals(stack.getMin(), new Integer(1));
    }

    public void testMin3RemoveDuplicate2() throws Exception {
        stack.push(3);
        stack.push(2);
        stack.push(1);
        stack.push(1);

        stack.pop();
        stack.pop();

        assertEquals(stack.size(), 2);
        assertEquals(stack.getMin(), new Integer(2));
    }
}