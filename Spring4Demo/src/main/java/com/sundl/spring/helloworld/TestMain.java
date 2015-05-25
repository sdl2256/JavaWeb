package com.sundl.spring.helloworld;

import com.sundl.spring.annotation.TestObject;
import com.sundl.spring.annotation.controller.UserController;
import com.sundl.spring.cycle.Cat;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by Sun on 2015/5/9.
 */
public class TestMain {

    public static void main(String[] args) throws SQLException {

//        HelloWorld helloWorld = new HelloWorld();
//        helloWorld.setName("第哦按");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        HelloWorld helloWorld = (HelloWorld) context.getBean("helloWorld");
//        helloWorld.hello();
        Car car = (Car) context.getBean("car");
        System.out.println(car);

        Person person = (Person) context.getBean("person");
        System.out.println(person);

        Person personbook = (Person) context.getBean("personbook");
        System.out.println(personbook);


        MyDataSource myDataSource = (MyDataSource) context.getBean("mydataSource");
        System.out.println(myDataSource);

//
//        DataSource dataSource = (DataSource) context.getBean("dataSource");
//        System.out.println("c3p0 link: " + dataSource.getConnection());
//        System.out.println("c3p0 link: " + dataSource.getConnection());

        Cat cat = (Cat) context.getBean("cat");
        System.out.println(cat.getName());

//
//        com.sundl.spring.factory.Car car2 = (com.sundl.spring.factory.Car) context.getBean("cars2");
//        System.out.println(car2);
//        com.sundl.spring.factory.Car car3 = (com.sundl.spring.factory.Car) context.getBean("cars3");
//        System.out.println(car3);
//        com.sundl.spring.factory.Car car4 = (com.sundl.spring.factory.Car) context.getBean("car4");
//        System.out.println(car4);
//
//        TestObject testObject = (TestObject) context.getBean("testObject");
//        System.out.println(testObject);
//
//        UserController userController = (UserController) context.getBean("userController");
//        userController.execute();
//        context.close();
    }
}
