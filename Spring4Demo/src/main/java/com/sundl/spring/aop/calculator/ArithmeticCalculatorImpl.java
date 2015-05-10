package com.sundl.spring.aop.calculator;

import org.springframework.stereotype.Component;

/**
 * Created by Sun on 2015/5/10.
 */
@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

    public int sub(int a, int b) {
        int result = a - b;
        return result;
    }

    public int mul(int a, int b) {
        int result = a * b;
        return result;
    }

    public int div(int a, int b) {
        int result = a / b;
        return result;
    }
}
