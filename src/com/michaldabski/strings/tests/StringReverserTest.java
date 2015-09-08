package com.michaldabski.strings.tests;

import com.michaldabski.strings.StringReverser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Michal on 01/09/2015.
 */
public class StringReverserTest {
    StringReverser stringReverser;

    @Before
    public void setUp() throws Exception {
        stringReverser = new StringReverser();
    }

    @Test
    public void testReverse() throws Exception {
        String reversed = stringReverser.reverse("abcde");
        Assert.assertEquals(reversed, "edcba");
    }

    @Test
    public void testReverseUnicode() throws Exception {
        String reversed = stringReverser.reverse("abcde");
        Assert.assertEquals(reversed, "edcba");
    }
}