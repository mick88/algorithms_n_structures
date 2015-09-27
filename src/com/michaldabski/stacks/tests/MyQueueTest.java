package com.michaldabski.stacks.tests;

import com.michaldabski.stacks.MyQueue;
import junit.framework.TestCase;

/**
 * Created by Michal on 27/09/2015.
 */
public class MyQueueTest extends TestCase {
    MyQueue<Integer> queue;

    @Override
    public void setUp() throws Exception {
        queue = new MyQueue<Integer>();
    }

    @Override
    public void tearDown() throws Exception {
        queue = null;
    }

    public void testQueue() throws Exception {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        assertEquals(6, queue.size());

        assertEquals(new Integer(1), queue.dequeue());
        assertEquals(new Integer(2), queue.dequeue());
        assertEquals(new Integer(3), queue.dequeue());
        assertEquals(new Integer(4), queue.dequeue());
        assertEquals(new Integer(5), queue.dequeue());
        assertEquals(new Integer(6), queue.dequeue());
        assertEquals(0, queue.size());
    }

    public void testQueue2() throws Exception {
        queue.enqueue(1);
        assertEquals(new Integer(1), queue.dequeue());
        queue.enqueue(2);
        assertEquals(new Integer(2), queue.dequeue());
        queue.enqueue(3);
        assertEquals(new Integer(3), queue.dequeue());
        queue.enqueue(4);
        assertEquals(new Integer(4), queue.dequeue());
        queue.enqueue(5);
        assertEquals(new Integer(5), queue.dequeue());
        queue.enqueue(6);
        assertEquals(new Integer(6), queue.dequeue());
        assertEquals(0, queue.size());
    }

    public void testSize() throws Exception {
        assertEquals(0, queue.size());
    }
}