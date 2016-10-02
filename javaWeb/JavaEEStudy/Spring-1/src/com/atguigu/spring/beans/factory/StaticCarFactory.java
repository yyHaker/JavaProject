package com.atguigu.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;

public class StaticCarFactory {
	private static Map<String, Car> cars=new HashMap<String, Car>();
	static {
		cars.put("audi",new Car("audi",30000.0));
		cars.put("fute",new Car("fute",40000.0));
	}
	
	
     public static Car getCar(String name){
    	 return cars.get(name);
     }
}
