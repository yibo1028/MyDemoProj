package com.yibo.demo.test;

import com.yibo.demo.Calculator;

import java.math.BigDecimal;

public class CalculatorTest {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        System.out.println(cal.getFinalResult());

        System.out.println(cal.add(BigDecimal.valueOf(8)));
        System.out.println(cal.subtract(BigDecimal.valueOf(2)));
        System.out.println(cal.multiply(BigDecimal.valueOf(5)));
        System.out.println(cal.divide(BigDecimal.valueOf(6)));

        System.out.println("--------------------");

        cal.undo();
        System.out.println(cal.getFinalResult());
        cal.undo();
        System.out.println(cal.getFinalResult());
        cal.undo();
        System.out.println(cal.getFinalResult());
        cal.undo();
        System.out.println(cal.getFinalResult());
        cal.undo();
        System.out.println(cal.getFinalResult());
        cal.undo();
        System.out.println(cal.getFinalResult());

        System.out.println("--------------------");

        cal.redo();
        System.out.println(cal.getFinalResult());
        cal.redo();
        System.out.println(cal.getFinalResult());
        cal.redo();
        System.out.println(cal.getFinalResult());
        cal.redo();
        System.out.println(cal.getFinalResult());
        cal.redo();
        System.out.println(cal.getFinalResult());
        cal.redo();
        System.out.println(cal.getFinalResult());

        System.out.println("--------------------");
        cal.undo();
        System.out.println(cal.getFinalResult());
        cal.redo();
        System.out.println(cal.getFinalResult());
    }
}
