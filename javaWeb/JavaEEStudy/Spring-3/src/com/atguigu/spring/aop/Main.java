package com.atguigu.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
       ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml"); 
       ArithmeticCalculator arithmeticCalculator=(ArithmeticCalculator) ctx.getBean("arithmeticCalculator");
       int result=arithmeticCalculator.add(4, 6);
       System.out.println(result);
       
       int result2=arithmeticCalculator.div(4, 9);
       System.out.println(result2);
	}

}
