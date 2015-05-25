package com.sundl.spring.aop.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sun on 2015/5/10.
 */
//声明为一个切面，需要放入IoC容器中，再声明为切面
@Order(2)
@Component
@Aspect
public class LoggingAspect {


    /**
     * 定义一个方法，用于声明切入点表达式，一般地，该方法中不需要写代码
     */
    @Pointcut("execution(public int com.sundl.spring.aop.calculator.ArithmeticCalculatorImpl.*(int,int))")
    public void declareJoinPointExpresion() {
    }


    //声明为前置通知，在哪些方法开始之前执行,自动生成代理对象
    @Before(value = "declareJoinPointExpresion()")
    public void beforeMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method " + name + " begins with " + args + ".");
    }

    @After("execution(public int com.sundl.spring.aop.calculator.ArithmeticCalculatorImpl.*(int,int))")
    public void afterMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.out.println("The method " + name + " ends.");
    }

    @AfterReturning(value = "execution(public int com.sundl.spring.aop.calculator.ArithmeticCalculatorImpl.*(..))",
            returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();
        System.out.println("The method " + name + " ends with " + result + ".");
    }

    @AfterThrowing(value = "execution(public int com.sundl.spring.aop.calculator.ArithmeticCalculatorImpl.*(..))",
            throwing = "ex")
    public void afterReturningMethod(JoinPoint joinPoint, Exception ex) {
        String name = joinPoint.getSignature().getName();
        System.out.println("The method " + name + " occurs exeption: " + ex + ".");
    }


    /**
     * 必须有：ProceedingJoinPoint
     * 必须有返回值，与目标方法一致
     *
     * @param proceedingJoinPoint
     */
    @Around("execution(public int com.sundl.spring.aop.calculator.ArithmeticCalculatorImpl.*(..))")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint) {

        Object object = null;
        //执行目标方法
        try {
            System.out.println("before mothod " + proceedingJoinPoint.getSignature().getName()
                    + " with " + Arrays.asList(proceedingJoinPoint.getArgs()));
            object = proceedingJoinPoint.proceed();
            System.out.println("end with " + object);
        } catch (Throwable e) {
            System.out.println("occurs exception: " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
        return object;
    }
}
