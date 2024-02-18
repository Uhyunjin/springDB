package com.fastcampus.ch3.diCopy2;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

class Car{}
class SportsCar extends Car{}
class Truck extends Car{}

class AppContext{
    Map map ; //객체 저장소

    AppContext() {
        //map.put("car", new SportsCar());
        //map.put("engine", new Engine());
        try {
            Properties p = new Properties();
            p.load(new FileReader("config.txt"));
            map = new HashMap(p);

            for (Object key : map.keySet()) {
                Class clazz = Class.forName((String) map.get(key));
                map.put(key, clazz.newInstance());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Object getBean(String key) {
        return map.get(key);
    }
}

class Engine {}

public class Main2 {
    public static void main(String[] args) throws Exception{
        AppContext ac = new AppContext();
        Car car = (Car)ac.getBean("car");
        System.out.println("car="+car);
        Engine engine = (Engine) ac.getBean("engine");
        System.out.println("engine="+engine);
    }
}
