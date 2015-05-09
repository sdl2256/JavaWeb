package com.sundl.helloworld;

import com.sundl.cycle.Cat;
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
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
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


        DataSource dataSource = (DataSource) context.getBean("dataSource");
        System.out.println("c3p0 link: " + dataSource.getConnection());
//        System.out.println("c3p0 link: " + dataSource.getConnection());

        Cat cat = (Cat) context.getBean("cat");
        System.out.println(cat.getName());

        context.close();
    }
}
