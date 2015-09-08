package com.michaldabski.matrices.tests;

import com.michaldabski.matrices.CopyRotater;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;

/**
 * Created by Michal on 08/09/2015.
 */
public class CopyRotaterTest extends MatrixRotaterTest {
    @Before
    public void setUp() throws Exception {
        this.matrixRotater = new CopyRotater();
    }

    @Test
    public void testNotSameMatrix() throws Exception {
        int[][] testMatrix = {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
        };
        final int[][] result = matrixRotater.rotateMatrix(testMatrix);
        assertNotSame(result, testMatrix);
    }
}
