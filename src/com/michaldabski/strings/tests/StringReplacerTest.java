package com.michaldabski.strings.tests;

import com.michaldabski.strings.StringReplacer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Michal on 02/09/2015.
 */
public class StringReplacerTest {
    StringReplacer replacer;

    @Before
    public void setUp() throws Exception {
        replacer = new StringReplacer();
    }

    @Test
    public void testReplace20() throws Exception {
        assertEquals("abc", replacer.replace20("abc"));
        assertEquals("abc%20def", replacer.replace20("abc def"));
        assertEquals("Michal%20Dabski", replacer.replace20("Michal Dabski"));
        assertEquals("abc%20def%20", replacer.replace20("abc def "));
        assertEquals("%20%20abc%20def%20", replacer.replace20("  abc def "));
    }
}