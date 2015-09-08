package com.michaldabski.strings.tests;

import com.michaldabski.strings.WordRotation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Michal on 08/09/2015.
 */
public class WordRotationTest {
    WordRotation wordRotation;

    @Before
    public void setUp() throws Exception {
        wordRotation = new WordRotation();
    }

    @Test
    public void testIsSubstring() throws Exception {
        assertTrue(wordRotation.isSubstring("needle", "needless"));
        try {
            assertTrue(wordRotation.isSubstring("needle", "needless"));
            fail("Should not allow to call isSubstring again");
        } catch (IllegalStateException ignored) {
            // pass
        }
    }

    @Test
    public void testIsRotation() throws Exception {
        assertTrue(wordRotation.isRotation("erbottlewat", "waterbottle"));
    }

    @Test
    public void testIsRotationEmpty() throws Exception {
        assertFalse(wordRotation.isRotation("erbottlewat", ""));
    }

    @Test
    public void testIsRotationEmptyReverse() throws Exception {
        assertFalse(wordRotation.isRotation("", "waterbottle"));
    }

    @Test
    public void testIsRotationSubstring() throws Exception {
        assertFalse(wordRotation.isRotation("erbottlewat", "water"));
    }
}