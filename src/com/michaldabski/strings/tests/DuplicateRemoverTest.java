package com.michaldabski.strings.tests;

import com.michaldabski.strings.DuplicateRemover;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Michal on 01/09/2015.
 */
public class DuplicateRemoverTest {
    DuplicateRemover duplicateRemover;

    @Before
    public void setUp() throws Exception {
        duplicateRemover = new DuplicateRemover();
    }

    @Test
    public void testRemoveDuplicates() throws Exception {
        assertEquals("a", duplicateRemover.removeDuplicates("aaaaaaaaaaaaaaaaaaaaaaaa"));
        assertEquals("abcde", duplicateRemover.removeDuplicates("abcde"));
        assertEquals("abcde", duplicateRemover.removeDuplicates("abcdea"));
        assertEquals("abcde", duplicateRemover.removeDuplicates("aabbccddee"));
//        assertEquals("Micha? D?bsk", duplicateRemover.removeDuplicates("Micha? D?bski"));
        assertEquals("Michal Dbsk", duplicateRemover.removeDuplicates("Michal Dabski"));
        assertEquals("Lutka", duplicateRemover.removeDuplicates("Lutka"));
        assertEquals("Paulin Ltk", duplicateRemover.removeDuplicates("Paulina Lutka"));
    }
}