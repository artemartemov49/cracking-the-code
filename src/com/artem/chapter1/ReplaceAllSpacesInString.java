package com.artem.chapter1;

public class ReplaceAllSpacesInString {

    public static void main(String[] args) {
        var array = "Mr John Smith    ".toCharArray();
        replaceAllSpaces(array, 13);
        System.out.println(array);
    }

    static void replaceAllSpaces(char[] s, int endIndex) {
        var counter = s.length-1;
        var endIndex1 = endIndex-1;

        for (int i = endIndex1; i >= 0; i--) {
            if (s[i] != ' ') {
                s[counter] = s[i];
                counter--;
            } else {
                addSymbols(s, counter);
                counter-=3;
            }

        }
    }

    static void addSymbols(char[] array, int endIndex) {
        array[endIndex] = '0';
        array[endIndex - 1] = '2';
        array[endIndex - 2] = '%';
    }
}
