package com.michaldabski.bit_ops;

/**
 * Created by Michal on 17/01/2016.
 */
public class BitOperations {
    /**
     * Copy subsequence of bits from M to N
     *
     * @param n     initial number
     * @param m     number to copy bits from
     * @param start starting index of the sequence
     * @param end   ending index of the sequence
     * @return n with bits i to j set to values in m
     */
    public int copySubBits(int n, int m, int start, int end) {
        int mask = 0;
        for (int i = start; i <= end; i++) {
            mask |= m & (1 << i);
        }

        return (n & ~mask) | (m << start);
    }
}
