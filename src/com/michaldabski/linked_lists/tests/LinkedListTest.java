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

        assertEquals(1, (int)testList.getItem(0));
        assertEquals(2, (int)testList.getItem(1));
        assertEquals(3, (int)testList.getItem(2));
        assertEquals(4, (int)testList.getItem(3));
        assertEquals(5, (int)testList.getItem(4));
        assertEquals(6, (int)testList.getItem(5));

        try {
            testList.getItem(6);
            fail("Exception should be thrown for index out of bounds");
        } catch (IndexOutOfBoundsException ignored){}

        try {
            testList.getItem(-1);
            fail("Exception should be thrown for index -1");
        } catch (IndexOutOfBoundsException ignored){}

        try {
            testList.getItem(10);
            fail("Exception should be thrown for index out of bounde");
        } catch (IndexOutOfBoundsException ignored){}

        try {
            new LinkedList<Integer>().getItem(0);
            fail("Exception should be thrown for getItem() if list is empty");
        } catch (IndexOutOfBoundsException ignored){}
    }
}