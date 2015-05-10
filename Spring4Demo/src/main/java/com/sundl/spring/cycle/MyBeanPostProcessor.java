package com.sundl.spring.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by Sun on 2015/5/10.
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postprocessbefore" + o + "," + s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postprocessafter" + o + "," + s);
        return o;
    }
}
