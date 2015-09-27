package com.michaldabski.stacks.tests;

import com.michaldabski.stacks.SetOfStacks;
import junit.framework.TestCase;

/**
 * Created by Michal on 27/09/2015.
 */
public class SetOfStacksTest extends TestCase {
    SetOfStacks setOfStacks;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        setOfStacks = new SetOfStacks(5);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
        setOfStacks = null;
    }

    public void testSetOfStacksSingleValue() throws Exception {
        setOfStacks.push(1);

        assertEquals(1, setOfStacks.pop());
    }

    public void testSetOfStacksSingleStack() throws Exception {
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);

        assertEquals(5, setOfStacks.pop());
        assertEquals(4, setOfStacks.pop());
        assertEquals(3, setOfStacks.pop());
        assertEquals(2, setOfStacks.pop());
        assertEquals(1, setOfStacks.pop());
    }

    public void testSetOfStacks() throws Exception {
        setOfStacks.push(1);
        setOfStacks.push(2);
        setOfStacks.push(3);
        setOfStacks.push(4);
        setOfStacks.push(5);
        setOfStacks.push(6);
        setOfStacks.push(7);
        setOfStacks.push(8);
        setOfStacks.push(9);
        setOfStacks.push(10);
        setOfStacks.push(11);

        assertEquals(11, setOfStacks.pop());
        assertEquals(10, setOfStacks.pop());
        assertEquals(9, setOfStacks.pop());
        assertEquals(8, setOfStacks.pop());
        assertEquals(7, setOfStacks.pop());
        assertEquals(6, setOfStacks.pop());
        assertEquals(5, setOfStacks.pop());
        assertEquals(4, setOfStacks.pop());
        assertEquals(3, setOfStacks.pop());
        assertEquals(2, setOfStacks.pop());
        assertEquals(1, setOfStacks.pop());
    }
}