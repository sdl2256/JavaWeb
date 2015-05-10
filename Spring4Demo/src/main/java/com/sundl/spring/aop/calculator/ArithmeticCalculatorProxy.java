package com.sundl.spring.aop.calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by Sun on 2015/5/10.
 */
public class ArithmeticCalculatorProxy {

    //要代理的对象
    private ArithmeticCalculator target;

    public ArithmeticCalculatorProxy(ArithmeticCalculatorImpl target) {
        this.target = target;
    }

    public ArithmeticCalculator getLoggingProxy() {
        ArithmeticCalculator proxy = null;

        //代理对象由哪一个类加载器负责加载
        ClassLoader loader = target.getClass().getClassLoader();
        //代理对象的类型，即其中有哪些方法
        Class[] interfaces = new Class[]{ArithmeticCalculator.class};

        /**
         * proxy:不在内部调用proxy方法，否则可能死循环
         * method:
         * args:
         */
        //当调用代理对象其中的方法时，该执行的代码
        InvocationHandler h = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //logging
                System.out.println("The method " + methodName + " begins with " + Arrays.asList(args));
                //method
                Object result = method.invoke(target, args);
                //logging
                System.out.println("The method " + methodName + " ends with " + result);
                return 0;
            }
        };

        proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
        return proxy;
    }

}
