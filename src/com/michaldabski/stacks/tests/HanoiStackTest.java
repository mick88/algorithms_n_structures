package com.michaldabski.stacks.tests;

import com.michaldabski.stacks.HanoiStack;
import junit.framework.TestCase;

/**
 * Created by Michal on 27/09/2015.
 */
public class HanoiStackTest extends TestCase {
    HanoiStack stack;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        stack = new HanoiStack();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        stack = null;
    }

    public void testPush() throws Exception {
        stack.push(15);
        stack.push(10);
        stack.push(5);
    }

    public void testPushLarger() throws Exception {
        stack.push(15);
        stack.push(10);
        stack.push(5);

        try {
            stack.push(10);
            fail("Bigger value cannot be allowed on top of smaller one");
        } catch (IllegalStateException ignored) {
            //pass
        }

        try {
            stack.push(5);
            fail("Equal value should now be allowed");
        } catch (IllegalStateException ignored) {
            //pass
        }
    }
}