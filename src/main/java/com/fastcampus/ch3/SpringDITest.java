package com.fastcampus.ch3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

class Car{}
class Engine{}
class Door{}


public class SpringDITest {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
        Car car = (Car)ac.getBean("car"); // byname
        Car car3 = ac.getBean("car", Car.class); // byname, 타입정보를 매개변수로 넘길 수 있음
        // xml scope=prototype으로 설정하면 getBean마다 새로운 객체가 생성된다
        // 기본 설정은 singleton으로 하나만 생성됌
        
        Car car2 = (Car)ac.getBean(Car.class); // bytype
        //Engine engine = (Engine) ac.getBean("engine"); //byname
        Engine engine2 = (Engine) ac.getBean(Engine.class); //bytype
        Door door = (Door) ac.getBean("door");


        System.out.println("car = " + car2);
        System.out.println("engine = " + engine2);
        System.out.println("door = " + door);
    }
}
