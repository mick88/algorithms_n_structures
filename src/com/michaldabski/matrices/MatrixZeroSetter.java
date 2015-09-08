package com.michaldabski.matrices;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Michal on 08/09/2015.
 * <p/>
 * "Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0."
 */
public class MatrixZeroSetter {

    public void setZeros(int[][] matrix) {
        Set<Integer> zeroRows = new HashSet<Integer>();
        Set<Integer> zeroCols = new HashSet<Integer>();

        // collect zeros from the matrix
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                int value = row[j];
                if (value == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        // write zeros to columns and rows
        for (int row : zeroRows) {
            final int[] cells = matrix[row];
            for (int i = 0; i < cells.length; i++) cells[i] = 0;
        }
        for (int row : zeroCols) {
            for (int i = 0; i < matrix.length; i++) matrix[i][row] = 0;
        }
    }
}
