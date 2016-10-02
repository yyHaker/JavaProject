package com.atguigu.spring.beans.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		 /**
		   * spring的方法
		   */
		  //1.创建spring的IOC容器对象
		      //ApplicationContext代表IOC容器
		      //ClassPathXmlApplicationContext是ApplicationContext的接口的实现类，该实现类从类路径下加载配置文件
		  ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		  //2.从IOC容器中获取bean
//		  Person person=(Person)ctx.getBean("person_3");
//		  System.out.println(person);
		  
//		  NewPerson newperson =(NewPerson) ctx.getBean("person_4");
//		  System.out.println(newperson);
		  
//		  DataSource datasource=(DataSource) ctx.getBean("DataSource");
//		  System.out.println(datasource.getProperties());
		  
		  Person person =(Person) ctx.getBean("person_6");
		  System.out.println(person);
	}

}
