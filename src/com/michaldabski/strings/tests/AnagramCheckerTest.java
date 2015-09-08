package com.michaldabski.strings.tests;

import com.michaldabski.strings.AnagramChecker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Michal on 01/09/2015.
 */
public class AnagramCheckerTest {
    AnagramChecker anagramChecker;

    @Before
    public void setUp() throws Exception {
        anagramChecker = new AnagramChecker();
    }

    @Test
    public void testIsAnagramLoops() throws Exception {
        assertEquals(true, anagramChecker.isAnagramLoops("ab", "ba"));
        assertEquals(true, anagramChecker.isAnagramLoops("rasp", "spar"));

        assertEquals(false, anagramChecker.isAnagramLoops("abc", "ba"));
        assertEquals(false, anagramChecker.isAnagramLoops("ba", "abc"));
    }

    @Test
    public void testIsAnagramLut() throws Exception {
        assertEquals(false, anagramChecker.isAnagramLut("abc", "ba"));
        assertEquals(false, anagramChecker.isAnagramLut("ba", "abc"));
        assertEquals(true, anagramChecker.isAnagramLut("rasp", "spar"));
        assertEquals(true, anagramChecker.isAnagramLut("raspberry", "sparrrybe"));
        assertEquals(false, anagramChecker.isAnagramLut("raspberry", "spar"));

    }

}