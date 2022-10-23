package com.artem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Permutation {

    public static void main(String[] args) {
        isPermutationIn("god", "dog");
    }

    static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);

        return new String(content);
    }

    static boolean isPermutationIn(String value, String stringToCheck) {
        if (value.length() != stringToCheck.length()) {
            return false;
        }
        Map<Character, Integer> chars = new HashMap<>();

        var charsInString = value.toCharArray();
        var charsToCheck = stringToCheck.toCharArray();

        for (int i = 0; i < value.length(); i++) {
            var secondChar = charsToCheck[i];

            if (chars.containsKey(secondChar)) {
                chars.merge(secondChar, -1, Integer::sum);
                if (chars.get(secondChar) == 0) {
                    chars.remove(secondChar);
                }
            }

            var firstChar = charsInString[i];
            if (chars.containsKey(firstChar)) {
                chars.merge(firstChar, 1, Integer::sum);
            } else if (firstChar != secondChar) {
                chars.put(firstChar, 1);
            }
        }

        chars.remove(charsToCheck[0]);
        return chars.isEmpty();
    }
}
