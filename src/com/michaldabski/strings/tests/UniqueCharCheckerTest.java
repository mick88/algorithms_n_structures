package com.michaldabski.strings.tests;

import com.michaldabski.strings.UniqueCharChecker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Michal on 01/09/2015.
 */
public class UniqueCharCheckerTest {
    UniqueCharChecker uniqueCharChecker;

    @Before
    public void setUp() throws Exception {
        uniqueCharChecker = new UniqueCharChecker();
    }

    @Test
    public void testHasAllUniqueChars() throws Exception {
        assertEquals(true, uniqueCharChecker.hasAllUniqueChars(""));
        assertEquals(true, uniqueCharChecker.hasAllUniqueChars("abcde"));
        assertEquals(false, uniqueCharChecker.hasAllUniqueChars("aabcde"));
        assertEquals(false, uniqueCharChecker.hasAllUniqueChars("abcdea"));
        assertEquals(true, uniqueCharChecker.hasAllUniqueChars("ABCDabcd"));
        assertEquals(true, uniqueCharChecker.hasAllUniqueChars("Micha?"));
    }
}