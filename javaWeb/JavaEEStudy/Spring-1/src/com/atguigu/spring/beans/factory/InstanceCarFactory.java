package com.atguigu.spring.beans.factory;

import java.util.HashMap;
import java.util.Map;
 /**
  * 实例工厂方法：实例工厂的方法即需要创建实例本身，在调用工厂的实例方法来返回bean的实例
  * @author 57217
  *
  */
public class InstanceCarFactory {
     private Map<String, Car> cars=null;
     
     public InstanceCarFactory(){
    	 cars=new HashMap<String, Car>();
    	 cars.put("audi",new Car("audi",4000.0));
    	 cars.put("baoma",new Car("baoma",7000.0));
     }
     public Car getCar(String name){
    	 return cars.get(name);
     }
 }
