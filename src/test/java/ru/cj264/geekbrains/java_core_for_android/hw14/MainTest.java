package ru.cj264.geekbrains.java_core_for_android.hw14;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MainTest {
    @ParameterizedTest
    @MethodSource("afterLast4_SamplesContaining4")
    void testAfterLast4WithArraysContaining4(Integer[] input, Integer[] output) {
        assertArrayEquals(output, Main.afterLast4(input));
    }

    static Stream<Arguments> afterLast4_SamplesContaining4() {
        return Stream.of(
                arguments(new Integer[]{1, 2, 3, 4, 5}, new Integer[]{5}),
                arguments(new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new Integer[]{1, 7})
        );
    }
}
