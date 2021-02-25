package ru.cj264.geekbrains.java_core_for_android.hw14;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class AfterLast4Test {
    @ParameterizedTest(name = "{index}: the rest of ''{0}'' afterLast4 is {1}")
    @MethodSource("afterLast4_SamplesContaining4")
    void afterLast4_ShouldGiveTheRestOfTheArrayContaining4(Integer[] input, Integer[] output) {
        assertArrayEquals(output, Main.afterLast4(input));
    }

    static Stream<Arguments> afterLast4_SamplesContaining4() {
        return Stream.of(
                arguments(new Integer[]{1, 2, 3, 4, 5}, new Integer[]{5}),
                arguments(new Integer[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new Integer[]{1, 7}),
                arguments(new Integer[]{4, 2, 6, 4}, new Integer[]{}),
                arguments(new Integer[]{-1, 2, -4, 4, -4, 7}, new Integer[]{-4, 7})
        );
    }

    @Test
    void afterLast4_ShouldThrowRuntimeExceptionWithNullInput() {
        assertThrows(RuntimeException.class, () -> Main.afterLast4(null));
    }

    @Test
    void afterLast4_ShouldThrowRuntimeExceptionWithEmptyArray() {
        Exception exception = assertThrows(RuntimeException.class, () ->
                Main.afterLast4(new Integer[] {}));
        assertTrue(exception.getMessage().contains("There is no 4"));
    }

    @Test
    void afterLast4_ShouldThrowRuntimeExceptionOnArrayWithout4() {
        Exception exception = assertThrows(RuntimeException.class, () ->
                Main.afterLast4(new Integer[] {1, 2, 3}));
        assertTrue(exception.getMessage().contains("There is no 4"));
    }

}
