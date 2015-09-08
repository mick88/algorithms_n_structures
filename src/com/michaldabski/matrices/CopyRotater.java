package com.michaldabski.matrices;

/**
 * Created by Michal on 05/09/2015.
 * <p/>
 * Matrix rotater implementation which allocates new matrix and makes a rotated copy
 */
public class CopyRotater extends MatrixRotater {
    /**
     * Rotates matrix by 90 degrees clockwise into a new matrix
     */
    @Override
    protected int[][] performRotate(int[][] matrix) {
        int len = matrix.length;
        int[][] result = new int[len][len];

        for (int y = 0; y < len; y++) {
            for (int x = 0; x < len; x++) {
                final int[] coords = calculatePointCoordinate(x, y, len);
                result[coords[1]][coords[0]] = matrix[y][x];
            }
        }

        return result;
    }
}
