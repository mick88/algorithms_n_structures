package com.michaldabski.strings;

/**
 * Created by Michal on 01/09/2015.
 */
public class DuplicateRemover {
    public String removeDuplicates(String string) {
        char[] chars = string.toCharArray();

        int pos = 0;
        for (int i = 0; i < chars.length; i++) {
            boolean duplicate = false;
            for (int j = 0; j < i; j++)
                if (chars[i] == chars[j]) {
                    duplicate = true;
                    break;
                }
            if (!duplicate) chars[pos++] = chars[i];
        }
        return new String(chars, 0, pos);
    }
}
