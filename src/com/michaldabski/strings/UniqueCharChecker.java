package com.michaldabski.strings;

/**
 * Created by Michal on 01/09/2015.
 */
public class UniqueCharChecker {
    public boolean hasAllUniqueChars(String string) {
        final int len = string.length();
        for (int i = 0; i < len; i++)
            for (int j = 0; j < i; j++)
                if (string.charAt(i) == string.charAt(j))
                    return false;
        return true;
    }
}
