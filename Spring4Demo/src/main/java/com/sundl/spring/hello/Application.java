package com.sundl.spring.hello;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sun on 2015/5/9.
 */
@Configuration
@ComponentScan
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello world.";
            }
        };
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();

    }
}
