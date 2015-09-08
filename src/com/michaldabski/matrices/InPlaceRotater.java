package com.michaldabski.matrices;

/**
 * Created by Michal on 05/09/2015.
 */
public class InPlaceRotater extends MatrixRotater {
    /**
     * Rotates matrix by 90 degrees clockwise in-place
     */
    @Override
    protected int[][] performRotate(int[][] matrix) {
        int len = matrix.length;

        // Add 1 to len to include the middle cells in the
        // matrix on one wall in case where matrix size is odd
        for (int y = 0; y < (len + 1) / 2; y++) {
            for (int x = 0; x < len / 2; x++) {
                rotatePoint(matrix, x, y);
            }
        }

        return matrix;
    }

    /**
     * Rotates a single point in the matrix in-place
     * by swapping around values in the 4 corresponding places
     */
    public void rotatePoint(int[][] matrix, int x, int y) {
        int val = matrix[y][x];
        int tmp;
        int[] coordinates;

        for (int i = 0; i < 4; i++) {
            coordinates = calculatePointCoordinate(x, y, matrix.length);
            x = coordinates[0];
            y = coordinates[1];
            tmp = matrix[y][x];
            matrix[y][x] = val;
            val = tmp;
        }
    }
}
