package com.michaldabski.matrices;

/**
 * Created by Michal on 02/09/2015.
 * <p/>
 * Base class for matrix rotation
 * <p/>
 * Implements validation
 */
public abstract class MatrixRotater {
    /**
     * Actual implementation of the rotation logic
     */
    protected abstract int[][] performRotate(int[][] matrix);

    /**
     * Calculates new X and Y coordinates for the point after the rotation
     * @param size size of the matrix
     * @return two element array containing new coordinates {X, Y}
     */
    public int[] calculatePointCoordinate(int x, int y, int size) {
        return new int[]{
                size - 1 - y,
                x,
        };
    }


    public void validateMatrix(int[][] matrix) {
        final int length = matrix.length;
        for (int[] row : matrix)
            if (row.length != length)
                throw new IllegalArgumentException(String.format("Matrix must be NxN. It is %dx%d", length, row.length));
    }

    /**
     * Rotates matrix 90 by 90 degrees
     * <p/>
     * This method validates that the matrix is NxN and then invokes method which actually performs the rotation
     */
    public int[][] rotateMatrix(int[][] matrix) {
        validateMatrix(matrix);
        return performRotate(matrix);
    }


}
