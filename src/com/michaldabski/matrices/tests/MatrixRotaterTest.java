package com.michaldabski.matrices.tests;

import com.michaldabski.matrices.MatrixRotater;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Michal on 02/09/2015.
 */
public abstract class MatrixRotaterTest {
    protected MatrixRotater matrixRotater;

    @After
    public void tearDown() throws Exception {
        matrixRotater = null;
    }

    void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(String.format("%d, ", cell));
            }
            System.out.println();
        }
    }

    @Test
    public void testValidateMatrix() throws Exception {
        int[][] testMatrix = {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
        };

        // should not throw exception
        matrixRotater.validateMatrix(testMatrix);
        matrixRotater.validateMatrix(new int[10][10]);

        try {
            matrixRotater.validateMatrix(new int[10][11]);
            fail("10x11 matrix should not be allowed");
        } catch (IllegalArgumentException ignored) {

        }

        try {
            matrixRotater.rotateMatrix(new int[10][11]);
            fail("10x11 matrix should not be allowed");
        } catch (IllegalArgumentException ignored) {

        }
    }

    @Test
    public void testRotate4x4() throws Exception {
        int[][] expectedMatrix = {
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4},
        };
        int[][] testMatrix = {
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
                {1, 2, 3, 4},
        };

        final int[][] actual = matrixRotater.rotateMatrix(testMatrix);
        assertEquals(expectedMatrix, actual);
    }


    @Test
    public void testRotate4x4Unique() throws Exception {
        // test with each number unique
        int[][] testMatrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        int[][] expectedMatrix = {
                {13, 9, 5, 1},
                {14, 10, 6, 2},
                {15, 11, 7, 3},
                {16, 12, 8, 4},
        };

        final int[][] actual = matrixRotater.rotateMatrix(testMatrix);
        assertEquals(expectedMatrix, actual);
    }


    @Test
    public void testRotateOddUnique() throws Exception {
        // test with each number unique nad odd number of values
        int[][] testMatrix = {
                {1, 2, 3,},
                {4, 5, 6,},
                {7, 8, 9,},
        };
        int[][] expectedMatrix = {
                {7, 4, 1},
                {8, 5, 2},
                {9, 6, 3},
        };

        final int[][] actual = matrixRotater.rotateMatrix(testMatrix);

        assertEquals(expectedMatrix, actual);
    }

    @Test
    public void testRotate2x2() throws Exception {
        int[][] expectedMatrix = {
                {1, 1,},
                {2, 2,},
        };
        int[][] testMatrix = {
                {1, 2,},
                {1, 2,},
        };

        final int[][] actual = matrixRotater.rotateMatrix(testMatrix);
        assertEquals(expectedMatrix, actual);
    }

    @Test
    public void testRotate10x10() throws Exception {
        int[][] expectedMatrix = {
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2,},
                {3, 3, 3, 3, 3, 3, 3, 3, 3, 3,},
                {4, 4, 4, 4, 4, 4, 4, 4, 4, 4,},
                {5, 5, 5, 5, 5, 5, 5, 5, 5, 5,},
                {6, 6, 6, 6, 6, 6, 6, 6, 6, 6,},
                {7, 7, 7, 7, 7, 7, 7, 7, 7, 7,},
                {8, 8, 8, 8, 8, 8, 8, 8, 8, 8,},
                {9, 9, 9, 9, 9, 9, 9, 9, 9, 9,},
                {10, 10, 10, 10, 10, 10, 10, 10, 10, 10,},
        };
        int[][] testMatrix = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
        };

        final int[][] actual = matrixRotater.rotateMatrix(testMatrix);
        assertEquals(expectedMatrix, actual);
    }

}