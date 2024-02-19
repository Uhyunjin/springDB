package com.fastcampus.ch3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Arrays;

class Car{
    String color;
    int oil;
    Engine engine;
    Door[] doors;

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
        Engine engine = (Engine) ac.getBean("engine"); //byname
        Engine engine2 = (Engine) ac.getBean(Engine.class); //bytype
        Door door = (Door) ac.getBean("door");

//        car.setColor("red");
//        car.setOil(100);
//        car.setEngine(engine);
//        car.setDoors(new Door[]{ac.getBean("door", Door.class), ac.getBean("door", Door.class)});
        // car객체의 멤버 초기화
        // door는 항상 다른 객체가 생성되어야 하므로 prototype으로 설정

        System.out.println("car = " + car);
    }
}
