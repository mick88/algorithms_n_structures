package com.michaldabski.strings;

/**
 * Created by Michal on 02/09/2015.
 */
public class StringReplacer {

    public String replace20(String string) {
        final String replaceWith = "%20";

        // Count occurences of space to calculate new length of the array
        int occurences = 0;
        int len = string.length();
        for (int i = 0; i < len; i++)
            if (string.charAt(i) == ' ')
                occurences++;

        // the %20 takes up thee times as much space as a space
        len += occurences * 2;

        char[] result = new char[len];
        int i = 0, j = 0;
        while (i < len) {
            final char c = string.charAt(j++);
            if (c == ' ') {
                result[i++] = '%';
                result[i++] = '2';
                result[i++] = '0';
            } else {
                result[i++] = c;
            }
        }


        return new String(result);
    }
}
