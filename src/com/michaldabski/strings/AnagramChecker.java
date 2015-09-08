package com.michaldabski.strings;

/**
 * Created by Michal on 01/09/2015.
 */
public class AnagramChecker {
    public boolean isAnagramLoops(String s1, String s2) {
        // edge case where first string is longer than the second
        if (s1.length() != s2.length()) return false;

        char[] chars = s1.toCharArray();
        for (int i = 0; i < s2.length(); i++) {
            final char c = s2.charAt(i);
            boolean found = false;
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == c) {
                    chars[j] = '\0';
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    /**
     * Implementation with a lookup table of counts
     */
    public boolean isAnagramLut(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] counts = new int[Character.MAX_VALUE + 1];
        for (int i = 0; i < s1.length(); i++) counts[s1.charAt(i)]++;

        for (int i = 0; i < s2.length(); i++) {
            final char c = s2.charAt(i);
            if (counts[c] > 0) counts[c]--;
            else return false;
        }

        return true;
    }
}
