package ru.cj264.geekbrains.java_core_for_android.hw14;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
    }

    public static Integer[] afterLast4(Integer[] input) {
        int lastIndexOf4 = Arrays.asList(input).lastIndexOf(4);

        if (lastIndexOf4 == -1) throw new RuntimeException("There is no 4 in array!");

        return Arrays.copyOfRange(input, lastIndexOf4 + 1, input.length);
    }

    public static boolean checkFor14(Integer[] input) {
        List<Integer> list = Arrays.asList(input);

        return list.contains(1) &&
                list.contains(4) &&
                list.stream().noneMatch(i -> i != 1 && i != 4);
    }
}
