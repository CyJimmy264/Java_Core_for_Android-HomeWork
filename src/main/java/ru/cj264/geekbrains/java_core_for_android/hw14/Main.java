package ru.cj264.geekbrains.java_core_for_android.hw14;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        
    }

    public static Integer[] afterLast4(Integer[] input) {
        int lastIndexOf4 = Arrays.asList(input).lastIndexOf(4);
        Integer[] result = Arrays.copyOfRange(input, lastIndexOf4 + 1, input.length);

        return result;
    }
}
