package com.michaldabski.stacks.tests;

import com.michaldabski.stacks.Sorter;
import junit.framework.TestCase;

import java.util.Stack;

/**
 * Created by Michal on 27/09/2015.
 */
public class SorterTest extends TestCase {

    public void testSort() throws Exception {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        Sorter<Integer> sorter = new Sorter<Integer>(stack);
        assertEquals(new Integer(4), stack.peek());
        assertEquals(4, stack.size());
        assertFalse(sorter.isSorted());

        sorter.sort();

        // stack size should not change
        assertEquals(4, stack.size());
        assertEquals(new Integer(1), stack.peek());
        assertTrue(sorter.isSorted());
    }

    public void testSortEmpty() throws Exception {
        Stack<Integer> stack = new Stack<Integer>();
        Sorter<Integer> sorter = new Sorter<Integer>(stack);
        assertEquals(0, stack.size());

        sorter.sort();

        // stack size should not change
        assertEquals(0, stack.size());
        assertTrue(sorter.isSorted());
    }

    public void testIsSorted() throws Exception {
        // already-sorted stack
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        Sorter<Integer> sorter = new Sorter<Integer>(stack);
        assertTrue(sorter.isSorted());
        assertEquals(4, stack.size());
        assertEquals(new Integer(1), stack.peek());
    }

    public void testIsSortedEmpty() throws Exception {
        // already-sorted stack
        Stack<Integer> stack = new Stack<Integer>();

        Sorter<Integer> sorter = new Sorter<Integer>(stack);
        assertTrue(sorter.isSorted());
        assertEquals(0, stack.size());
    }

    public void testIsNotSorted() throws Exception {
        // already-sorted stack
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(4);
        stack.push(3);
        stack.push(2);

        Sorter<Integer> sorter = new Sorter<Integer>(stack);
        assertFalse(sorter.isSorted());
        assertEquals(4, stack.size());
    }
}