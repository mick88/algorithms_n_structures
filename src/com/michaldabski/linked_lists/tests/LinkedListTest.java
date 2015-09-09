package com.michaldabski.linked_lists.tests;


import com.michaldabski.linked_lists.LinkedList;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michal on 08/09/2015.
 */
public class LinkedListTest {

    @Test
    public void testConstructor() throws Exception {
        new LinkedList<String>(null);
        new LinkedList<String>("test", null);
        new LinkedList<Integer>(342, null);
        new LinkedList<Boolean>(true);
    }

    @Test
    public void testAddValue() throws Exception {
        LinkedList<Integer> list = new LinkedList<Integer>(1, 2, 3);
        list.addValue(4);
        assertEquals(new LinkedList<Integer>(1, 2, 3, 4), list);
    }

    @Test
    public void testAddValueEmpty() throws Exception {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.addValue(4);
        assertEquals(new LinkedList<Integer>(4), list);
    }

    @Test
    public void testToString() throws Exception {
        LinkedList<Integer> list = new LinkedList<Integer>(1, 2, 3);
        assertEquals("[1]->[2]->[3]", list.toString());
    }

    @Test
    public void testEquals() throws Exception {
        final LinkedList<Integer> testList = new LinkedList<Integer>(1, 2, 3);

        assertEquals(testList, new LinkedList<Integer>(1, 2, 3));

        assertNotEquals(testList, new LinkedList<Integer>(1, 2, 3, 4));
        assertNotEquals(testList, new LinkedList<Integer>(2, 3, 4));
        assertNotEquals(testList, new LinkedList<Integer>(1, 2));
        assertNotEquals(testList, new LinkedList<Integer>());
        assertNotEquals(testList, new LinkedList<Integer>(null));
        assertNotEquals(testList, new LinkedList<Integer>(null, null));
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, new LinkedList<Integer>().size());
        assertEquals(1, new LinkedList<Integer>(1).size());
        assertEquals(2, new LinkedList<Integer>(1, 2).size());
    }

    @Test
    public void testRemoveDuplicates() throws Exception {
        LinkedList<Integer> testList = new LinkedList<Integer>(1, 2, 3, 4, 3);

        assertNotEquals(new LinkedList<Integer>(1, 2, 3, 4), testList);
        testList.removeDuplicates();
        assertEquals(new LinkedList<Integer>(1, 2, 3, 4), testList);
    }

    @Test
    public void testRemoveDuplicatesAdjacent() throws Exception {
        LinkedList<Integer> testList = new LinkedList<Integer>(1, 2, 3, 3, 4);

        assertNotEquals(new LinkedList<Integer>(1, 2, 3, 4), testList);
        testList.removeDuplicates();
        assertEquals(new LinkedList<Integer>(1, 2, 3, 4), testList);
    }

    @Test
    public void testRemoveDuplicatesAll() throws Exception {
        LinkedList<Integer> testList = new LinkedList<Integer>(1, 1, 1, 1, 1);

        assertNotEquals(new LinkedList<Integer>(1), testList);
        testList.removeDuplicates();
        assertEquals(new LinkedList<Integer>(1), testList);
    }

    @Test
    public void testGetItem() throws Exception {
        LinkedList<Integer> testList = new LinkedList<Integer>(1, 2, 3, 4, 5, 6);

        assertEquals(1, (int) testList.getItem(0));
        assertEquals(2, (int) testList.getItem(1));
        assertEquals(3, (int) testList.getItem(2));
        assertEquals(4, (int) testList.getItem(3));
        assertEquals(5, (int) testList.getItem(4));
        assertEquals(6, (int) testList.getItem(5));

        try {
            testList.getItem(6);
            fail("Exception should be thrown for index out of bounds");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            testList.getItem(-1);
            fail("Exception should be thrown for index -1");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            testList.getItem(10);
            fail("Exception should be thrown for index out of bounde");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            new LinkedList<Integer>().getItem(0);
            fail("Exception should be thrown for getItem() if list is empty");
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    @Test
    public void testDeleteNode() throws Exception {
        LinkedList<Integer> list = new LinkedList<Integer>(1, 2, 3, 4, 5, 6);
        final LinkedList.Node<Integer> head = list.head;
        final LinkedList.Node<Integer> node3 = head.next.next;
        final LinkedList.Node<Integer> node6 = node3.next.next.next;

        try {
            list.deleteNode(null);
            fail("Null node should not be allowed");
        } catch (NullPointerException ignored) {
        }

        // deleting a foreign node should have no effect even if node with the same value exists
        list.deleteNode(new LinkedList.Node<Integer>(5));
        assertEquals(new LinkedList<Integer>(1, 2, 3, 4, 5, 6), list);

        // deleting node from the middle
        list.deleteNode(node3);
        assertEquals(new LinkedList<Integer>(1, 2, 4, 5, 6), list);

        // deleting head
        list.deleteNode(head);
        assertEquals(new LinkedList<Integer>(2, 4, 5, 6), list);

        // deleting last node
        list.deleteNode(node6);
        assertEquals(new LinkedList<Integer>(2, 4, 5), list);

        // deleting from an empty list should raise no exceptions
        new LinkedList<Integer>().deleteNode(head);

    }

    @Test
    public void testArithmeticAdd() throws Exception {
        assertEquals(new LinkedList<Integer>(3, 1, 5).arithmeticAdd(new LinkedList<Integer>(5, 9, 2)), new LinkedList<Integer>(8, 0, 8));
        assertEquals(new LinkedList<Integer>(3, 1, 5, 4).arithmeticAdd(new LinkedList<Integer>(5, 9, 2)), new LinkedList<Integer>(8, 0, 8, 4));
        assertEquals(new LinkedList<Integer>(3, 1, 5).arithmeticAdd(new LinkedList<Integer>(5, 9, 2, 4)), new LinkedList<Integer>(8, 0, 8, 4));
        assertEquals(new LinkedList<Integer>(0).arithmeticAdd(new LinkedList<Integer>(5, 9, 2, 4)), new LinkedList<Integer>(5, 9, 2, 4));
        assertEquals(new LinkedList<Integer>(1).arithmeticAdd(new LinkedList<Integer>(5, 9, 2, 4)), new LinkedList<Integer>(6, 9, 2, 4));
        assertEquals(new LinkedList<Integer>(5, 9, 2, 4).arithmeticAdd(new LinkedList<Integer>(0)), new LinkedList<Integer>(5, 9, 2, 4));
        assertEquals(new LinkedList<Integer>(5, 9, 2, 4).arithmeticAdd(new LinkedList<Integer>(1)), new LinkedList<Integer>(6, 9, 2, 4));
    }

    @Test
    public void testGetLastNode() throws Exception {
        LinkedList<Integer> list = new LinkedList<Integer>(1, 2, 3, 4, 5, 6);
        assertEquals(6, (int) list.getLastNode().getData());
        assertNull(new LinkedList<Integer>().getLastNode());
    }

    @Test
    public void testGetBeginningOfLoop() throws Exception {

        LinkedList<Integer> list = new LinkedList<Integer>(1, 2, 3, 4, 5, 6);
        final LinkedList.Node<Integer> loop = list.head.next.next.next; //4
        list.getLastNode().next = loop;
        assertSame(loop, list.getBeginningOfLoop());
        assertEquals(4, (int) list.getBeginningOfLoop().getData());

        // empty list
        assertNull(new LinkedList<Integer>().getBeginningOfLoop());
        // non-looped list
        assertNull(new LinkedList<Integer>(1, 2, 3).getBeginningOfLoop());
    }
}