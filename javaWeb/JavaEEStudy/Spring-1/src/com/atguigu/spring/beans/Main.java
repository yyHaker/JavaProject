package com.atguigu.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
  public static void main(String []args){
	  /**
	   * 传统方法
	   */
//	    HelloWorld helloworld=new HelloWorld();
//	    helloworld.setName("leyuan");
//	    helloworld.Hello();
	  
	  /**
	   * spring的方法
	   */
	  //1.创建spring的IOC容器对象
	      //ApplicationContext代表IOC容器
	      //ClassPathXmlApplicationContext是ApplicationContext的接口的实现类，该实现类从类路径下加载配置文件
	  ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	  
	  //2.从IOC容器中获取bean
//	  HelloWorld helloWorld=(HelloWorld)ctx.getBean("helloworld");
	  //3.调用hello方法
//	  helloWorld.Hello();
	  
//	  Car car=(Car)ctx.getBean("car");
//	  System.out.println(car);
//	  
//	  Car car2=(Car)ctx.getBean("car2");
//	  System.out.println(car2);
	  
	  Person person=(Person)ctx.getBean("person_2");
	  System.out.println(person);
  }
}
