package com.skypro.calculator;

import com.skypro.calculator.service.CalculatorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CalculatorServiceTests {
    CalculatorService calculatorService = new CalculatorService();

    @ParameterizedTest
    @MethodSource("plusTestArgs")
    public void plusTest (int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.plus(num1,num2));
    }

    @ParameterizedTest
    @MethodSource("minusTestArgs")
    public void minusTest (int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.minus(num1,num2));
    }

    @ParameterizedTest
    @MethodSource("multiplyTestArgs")
    public void multiplyTest (int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.multiply(num1,num2));
    }

    @ParameterizedTest
    @MethodSource("divideTestArgs")
    public void divideTest (int num1, int num2, int result) {
        Assertions.assertEquals(result, calculatorService.divide(num1,num2));
    }

    @Test
    public void divideByZeroThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculatorService.divide(5,0));
    }


    public static List<Arguments> plusTestArgs() {
        return List.of (
                Arguments.of(8, 2, 10),
                Arguments.of(-15, 5, -10),
                Arguments.of(0, 0, 0)
        );
    }

    public static List<Arguments> minusTestArgs() {
        return List.of (
                Arguments.of(8, 2, 6),
                Arguments.of(-15, 5, -20),
                Arguments.of(0, 0, 0)
        );
    }

    public static List<Arguments> multiplyTestArgs() {
        return List.of (
                Arguments.of(8, 2, 16),
                Arguments.of(-15, 5, -75),
                Arguments.of(0, 0, 0)
        );
    }

    public static List<Arguments> divideTestArgs() {
        return List.of (
                Arguments.of(8, 2, 4),
                Arguments.of(-15, 5, -3),
                Arguments.of(20, 4, 5)
        );
    }
}

