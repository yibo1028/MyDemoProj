package com.yibo.demo;

import java.math.BigDecimal;
import java.util.Deque;
import java.util.LinkedList;

public class Calculator {
    /**
     * 最终结果
     */
    private BigDecimal finalResult;
    /**
     * 存储历史结果的栈
     */
    private Deque<BigDecimal> historyResultStack;
    /**
     * 存储redo记录的栈
     */
    private Deque<BigDecimal> redoStack;

    public Calculator() {
        historyResultStack = new LinkedList<>();
        redoStack = new LinkedList<>();
        finalResult = BigDecimal.ZERO;
        historyResultStack.push(finalResult);
    }


    public BigDecimal add(BigDecimal number) {
        finalResult = finalResult.add(number);
        historyResultStack.push(finalResult);
        return finalResult;
    }

    public BigDecimal subtract(BigDecimal number) {
        finalResult = finalResult.subtract(number);
        historyResultStack.push(finalResult);
        return finalResult;
    }

    public BigDecimal multiply(BigDecimal number) {
        finalResult = finalResult.multiply(number);
        historyResultStack.push(finalResult);
        return finalResult;
    }

    public BigDecimal divide(BigDecimal number) {
        if (number.compareTo(BigDecimal.ZERO) == 0) {
            throw new IllegalArgumentException("除数不能为0");
        }
        finalResult = finalResult.divide(number, BigDecimal.ROUND_HALF_UP);
        historyResultStack.push(finalResult);
        return finalResult;
    }

    public BigDecimal getFinalResult() {
        return finalResult;
    }

    /**
     * undo操作
     */
    public void undo() {
        //由于historyResultStack记录了finalResult初始值，需要historyResultStack≥2才能undo
        if (historyResultStack.size() >= 2) {
            BigDecimal preResult = historyResultStack.pop();
            //将前一次的结果存入redoStack
            redoStack.push(preResult);
            finalResult = historyResultStack.peek();
            System.out.println("undo前:" + preResult + ",undo后:" + finalResult);
        } else {
            System.out.println("无法undo");
        }
    }

    /**
     * redo操作
     */
    public void redo() {
        if (!redoStack.isEmpty()) {
            BigDecimal preResult = finalResult;
            finalResult = redoStack.pop();
            //将前一次的结果存入historyResultStack
            historyResultStack.push(finalResult);
            System.out.println("redo前:" + preResult + ",redo后:" + finalResult);
        } else {
            System.out.println("无法redo");
        }
    }
}
