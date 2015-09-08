package com.michaldabski.strings;

/**
 * Created by Michal on 01/09/2015.
 */
public class StringReverser {
    public String reverse(String s) {
        char[] reversed = new char[s.length()];
        int len = reversed.length;
        for (int i = 0; i < reversed.length; i++) {
            reversed[len - 1 - i] = s.charAt(i);
        }
        return new String(reversed);
    }
}
