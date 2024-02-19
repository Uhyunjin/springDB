package com.fastcampus.ch3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class Car{
    @Value("red")
    String color;
    @Value("100")
    int oil;
    @Autowired Engine engine;
    @Autowired Door[] doors;

    // xml의 constuctor-arg에서 사용


    public void setColor(String color) {
        this.color = color;
    }

    public void setOil(int oil) {
        this.oil = oil;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public void setDoors(Door[] doors) {
        this.doors = doors;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", oil=" + oil +
                ", engine=" + engine +
                ", doors=" + Arrays.toString(doors) +
                '}';
    }
}

@Component("engine") class Engine{}
// <bean id="engine" class="com.fastcampus.ch3.Engine"/>과 똑같은 의미!!
@Component class SuperEngine extends Engine {}
@Component class TurboEngine extends Engine {}
@Component class Door{}


public class SpringDITest {
    public static void main(String[] args) {
        ApplicationContext ac = new GenericXmlApplicationContext("config.xml");
        Car car = (Car)ac.getBean("car"); // byname
        // xml scope=prototype으로 설정하면 getBean마다 새로운 객체가 생성된다
        // 기본 설정은 singleton으로 하나만 생성됌
        
//        Car car2 = (Car)ac.getBean(Car.class); // bytype

        Engine engine = (Engine) ac.getBean("superEngine"); //byname

        //Engine engine = (Engine) ac.getBean(Engine.class); //bytype
        //Engine type이 3개라서 타입으로 주면 에러난다

//        Door door = (Door) ac.getBean("door");

//        car.setColor("red");
//        car.setOil(100);
//        car.setEngine(engine);
//        car.setDoors(new Door[]{ac.getBean("door", Door.class), ac.getBean("door", Door.class)});
        // car객체의 멤버 초기화
        // door는 항상 다른 객체가 생성되어야 하므로 prototype으로 설정

        System.out.println("car = " + car);
        System.out.println("engine = " + engine);
    }
}
