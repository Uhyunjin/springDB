package com.fastcampus.ch3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class Car{}
class Engine{}
class Door{}


public class SpringDITest {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
        //Car car = (Car)ac.getBean("car"); // byname
        Car car2 = (Car)ac.getBean(Car.class); // bytype
        //Engine engine = (Engine) ac.getBean("engine"); //byname
        Engine engine2 = (Engine) ac.getBean(Engine.class); //bytype
        Door door = (Door) ac.getBean("door");
        System.out.println("car = " + car2);
        System.out.println("engine = " + engine2);
        System.out.println("door = " + door);
    }
}
