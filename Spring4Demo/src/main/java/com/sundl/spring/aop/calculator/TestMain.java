package com.sundl.spring.aop.calculator;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sun on 2015/5/10.
 */
public class TestMain {
    public static void main(String[] args) {
//        ArithmeticCalculator arithmeticCalculator = null;
//        arithmeticCalculator = new ArithmeticCalculatorImpl();
//        int result = arithmeticCalculator.add(4, 2);
//
//        System.out.println("-->" + result);
        /*
        ArithmeticCalculatorImpl target = new ArithmeticCalculatorImpl();
        ArithmeticCalculator proxy = new ArithmeticCalculatorProxy(target).getLoggingProxy();

        int result = proxy.add(4, 2);
        */

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) context.getBean("arithmeticCalculatorImpl");

        System.out.println("代理对象：" + arithmeticCalculator.getClass().getName());

        arithmeticCalculator.add(4, 2);
        arithmeticCalculator.div(4, 1);


    }
}
