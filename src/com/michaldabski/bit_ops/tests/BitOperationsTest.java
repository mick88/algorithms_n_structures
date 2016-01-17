package com.michaldabski.bit_ops.tests;

import com.michaldabski.bit_ops.BitOperations;
import junit.framework.TestCase;

/**
 * Created by Michal on 17/01/2016.
 */
public class BitOperationsTest extends TestCase {
    BitOperations bitOperations;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        this.bitOperations = new BitOperations();
    }


    public void testCopySubBits() throws Exception {
        int n = Integer.parseInt(       "10000000000", 2);
        final int m = Integer.parseInt(       "10101", 2);
        int expected = Integer.parseInt("10001010100", 2);

        n = bitOperations.copySubBits(n, m, 2, 6);
        assertEquals(expected, n);

    }
}