package com.atguigu.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//把这个类声明为一个切面：需要把该类放到IOC容器中，再声明为一个切面
@Aspect
@Component
public class LoggingAspect {
	//声明方法是一个前置通知：在目标方法开始之前执行
   @Before("execution(*  com.atguigu.spring.aop.impl.*.*(int, int))")	
   public void  beforeMathod(JoinPoint joinPoint){
	   //获得方法名
	   String methodName=joinPoint.getSignature().getName();
	   //获得方法参数
	   List<Object> args=Arrays.asList(joinPoint.getArgs());
	   System.out.println("The method  "+methodName+" begins with" +args);
   }
   
   //后置通知  :在目标方法执行后（无论是否发生异常），执行的通知
   //在后置通知中不能访问目标方法执行的结果
   @After("execution(*  com.atguigu.spring.aop.impl.*.*(int, int))")	
   public void afterMethod(JoinPoint joinPoint){
	   //获得方法名
	   String methodName=joinPoint.getSignature().getName();
	   System.out.println("The method  "+methodName+" end...");
   }
	
}
