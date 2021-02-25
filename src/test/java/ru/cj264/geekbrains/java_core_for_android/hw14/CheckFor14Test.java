package ru.cj264.geekbrains.java_core_for_android.hw14;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CheckFor14Test {
    @ParameterizedTest(name = "{index}: should be ''{1}'' for ''{0}''")
    @MethodSource("checkFor14_SamplesWithBothAndOnly14")
    void checkFor14_ShouldReturnTrueOnBothAndOnly14Arrays(Integer[] input, boolean result) {
        assertEquals(result, Main.checkFor14(input));
    }

    static Stream<Arguments> checkFor14_SamplesWithBothAndOnly14() {
        return Stream.of(
                arguments(new Integer[]{1, 1, 1, 4, 1}, true),
                arguments(new Integer[]{4, 4, 4, 4, 1}, true),
                arguments(new Integer[]{1, 4}, true),
                arguments(new Integer[]{1, 1, 1, 4, 4, 1, 4, 4}, true)
        );
    }

    @ParameterizedTest(name = "{index}: should be ''{1}'' for ''{0}''")
    @MethodSource("checkFor14_SamplesJustOneOf14InArray")
    void checkFor14_ShouldReturnFalseOnJustOneOf14InArray(Integer[] input, boolean result) {
        assertEquals(result, Main.checkFor14(input));
    }

    static Stream<Arguments> checkFor14_SamplesJustOneOf14InArray() {
        return Stream.of(
                arguments(new Integer[]{1, 1, 1, 1, 1, 1}, false),
                arguments(new Integer[]{1}, false),
                arguments(new Integer[]{4, 4}, false),
                arguments(new Integer[]{4, 4, 4, 4}, false)
        );
    }

    @ParameterizedTest(name = "{index}: should be ''{1}'' for ''{0}''")
    @MethodSource("checkFor14_SamplesWithOtherThan14InArray")
    void checkFor14_ShouldReturnFalseOnOtherThan14InArray(Integer[] input, boolean result) {
        assertEquals(result, Main.checkFor14(input));
    }

    static Stream<Arguments> checkFor14_SamplesWithOtherThan14InArray() {
        return Stream.of(
                arguments(new Integer[]{1, 4, 4, 1, 1, 4, 3}, false),
                arguments(new Integer[]{888}, false),
                arguments(new Integer[]{4, 717, 4, 1}, false),
                arguments(new Integer[]{1, -1, 4, -4}, false)
        );
    }

}
