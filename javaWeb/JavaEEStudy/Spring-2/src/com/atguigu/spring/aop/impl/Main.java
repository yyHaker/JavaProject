package com.atguigu.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
      //1.创建spring的ioc容器
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		
	  //2.从IOC的容器中获取bean的实例
		ArithmeticCalculator arithmeticCaculator=ctx.getBean(ArithmeticCalculator.class);
	
	  //3.使用bean
	  int result=  arithmeticCaculator.add(3, 6);	
	  System.out.println(result);
	  
	  int result2=  arithmeticCaculator.div(4, 6);
	  System.out.println(result2);
	}

}
