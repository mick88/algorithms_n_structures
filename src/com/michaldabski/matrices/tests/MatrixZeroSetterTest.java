package com.michaldabski.matrices.tests;

import com.michaldabski.matrices.MatrixZeroSetter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Michal on 08/09/2015.
 */
public class MatrixZeroSetterTest {

    MatrixZeroSetter matrixZeroSetter;

    @Before
    public void setUp() throws Exception {
        matrixZeroSetter = new MatrixZeroSetter();
    }

    @Test
    public void testSetZeros() throws Exception {
        int[][] testMatrix = {
                {1, 2, 3},
                {1, 0, 3},
        };
        int[][] expectedMatrix = {
                {1, 0, 3},
                {0, 0, 0},
        };

        assertNotEquals(testMatrix, expectedMatrix);
        matrixZeroSetter.setZeros(testMatrix);
        assertEquals(testMatrix, expectedMatrix);
    }

    @Test
    public void testSetZeros2() throws Exception {
        int[][] testMatrix = {
                {1, 2, 3},
                {1, 5, 3},
        };
        int[][] expectedMatrix = {
                {1, 2, 3},
                {1, 5, 3},
        };

        assertEquals(testMatrix, expectedMatrix);
        matrixZeroSetter.setZeros(testMatrix);
        assertEquals(testMatrix, expectedMatrix);
    }

    @Test
    public void testSetZerosOne() throws Exception {
        int[][] testMatrix = {
                {0, },
        };
        int[][] expectedMatrix = {
                {0, },
        };

        assertEquals(testMatrix, expectedMatrix);
        matrixZeroSetter.setZeros(testMatrix);
        assertEquals(testMatrix, expectedMatrix);
    }

    @Test
    public void testSetZerosEmpty() throws Exception {
        int[][] testMatrix = {
                {},
        };
        int[][] expectedMatrix = {
                {},
        };

        assertEquals(testMatrix, expectedMatrix);
        matrixZeroSetter.setZeros(testMatrix);
        assertEquals(testMatrix, expectedMatrix);
    }
}