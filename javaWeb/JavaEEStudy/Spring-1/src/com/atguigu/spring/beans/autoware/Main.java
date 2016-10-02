package com.atguigu.spring.beans.autoware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		 //1.创建spring的IOC容器对象
	      //ApplicationContext代表IOC容器
	      //ClassPathXmlApplicationContext是ApplicationContext的接口的实现类，该实现类从类路径下加载配置文件
	  ApplicationContext ctx=new ClassPathXmlApplicationContext("beans-autowire.xml");
	  //2.从IOC容器中获取bean
	  Person person=(Person) ctx.getBean("person");
	  System.out.println(person);
	}

}
