package com.michaldabski.strings;

/**
 * Created by Michal on 08/09/2015.
 * <p/>
 * "Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
 * (i.e., “waterbottle” is a rotation of “erbottlewat”)."
 */
public class WordRotation {

    int counter = 0;

    /**
     * Checks whether needle is substring of haystack
     * <p/>
     * This method can only be called once per instance of this class to enforce limitation imposed by the problem.
     *
     * @param needle   - contained string
     * @param haystack - larger string
     * @return boolean true if needle is a substring of haystack
     */
    public boolean isSubstring(String needle, String haystack) {
        if (counter++ > 0) throw new IllegalStateException("You can only call this method once!");
        return haystack.contains(needle);
    }

    public boolean isRotation(String s1, String s2) {
        // Strings must be equal length
        if (s1.length() != s2.length()) return false;

        final String haystack = s2 + s2;
        return isSubstring(s1, haystack);
    }
}
