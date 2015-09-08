package com.michaldabski.matrices.tests;

import com.michaldabski.matrices.InPlaceRotater;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by Michal on 08/09/2015.
 */
public class InPlaceRotaterTest extends MatrixRotaterTest {
    @Before
    public void setUp() throws Exception {
        this.matrixRotater = new InPlaceRotater();
    }

    @Test
    public void testRotatePoint() throws Exception {
        InPlaceRotater matrixRotater = new InPlaceRotater();
        int[][] matrix = {
                {1, 2},
                {3, 4},
        };
        matrixRotater.rotatePoint(matrix, 0, 0);
        assertEquals(matrix[0][0], 3);
        assertEquals(matrix[0][1], 1);
        assertEquals(matrix[1][0], 4);
        assertEquals(matrix[1][1], 2);
    }

    @Test
    public void testSameMatrix() throws Exception {
        int[][] testMatrix = {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
        };
        final int[][] result = matrixRotater.rotateMatrix(testMatrix);
        assertSame(result, testMatrix);
    }
}
