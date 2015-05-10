package com.sundl.spring.aop.calculator;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Sun on 2015/5/10.
 */
@Order(1)
@Aspect
@Component
public class ValidationAspect {

    @Before(value = "LoggingAspect.declareJoinPointExpresion()")
    public void validateArgs(JoinPoint joinPoint) {
        System.out.println("validation aspect ");
    }
}
