package com.atguigu.spring.aop;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
/**
 * 可以用@Order来指定优先级,值越小优先级越高
 * @author 57217
 *
 */


@Order(2)
//把这个类声明为一个切面：需要把该类放到IOC容器中，再声明为一个切面
@Aspect
@Component
public class LoggingAspect {
	//声明方法是一个前置通知：在目标方法开始之前执行
   @Before("execution(*  com.atguigu.spring.aop.*.*(int, int))")	
   public void  beforeMathod(JoinPoint joinPoint){
	   //获得方法名
	   String methodName=joinPoint.getSignature().getName();
	   //获得方法参数
	   List<Object> args=Arrays.asList(joinPoint.getArgs());
	   System.out.println("The method  "+methodName+" begins with" +args);
   }
   
   //后置通知  :在目标方法执行后（无论是否发生异常），执行的通知
   //在后置通知中不能访问目标方法执行的结果
   @After("execution(*  com.atguigu.spring.aop.*.*(int, int))")	
   public void afterMethod(JoinPoint joinPoint){
	   //获得方法名
	   String methodName=joinPoint.getSignature().getName();
	   System.out.println("The method  "+methodName+" end...");
   }
   
  //返回通知，在方法正常结束时执行的代码，返回通知是可以访问到方法的返回值的
   @AfterReturning(value="execution(*  com.atguigu.spring.aop.*.*(int, int))",
		   returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
	   //获得方法名
	   String methodName=joinPoint.getSignature().getName();
	   System.out.println("The method "+methodName+" end  with "+ result);
   }
  //异常通知
   //在目标方法出现异常时会执行的代码，可以访问到异常对象；且可以指定出现特定异常时在执行通知代码
   @AfterThrowing(value="execution(*  com.atguigu.spring.aop.*.*(int, int))",
		   throwing="ex")
   public void afterThrowing(JoinPoint joinPoint,Exception ex){
	   String methodName=joinPoint.getSignature().getName();
	   System.out.println("The method "+methodName+"occurs exception:"+ex);
   }
   
   /**
	 * 环绕通知需要携带 ProceedingJoinPoint 类型的参数. 
	 * 环绕通知类似于动态代理的全过程: ProceedingJoinPoint 类型的参数可以决定是否执行目标方法.
	 * 且环绕通知必须有返回值, 返回值即为目标方法的返回值
	 */
	
	/*@Around("execution(*  com.atguigu.spring.aop.*.*(int, int))")
	public Object aroundMethod(ProceedingJoinPoint pjd){
		
		Object result = null;
		String methodName = pjd.getSignature().getName();
		
		try {
			//前置通知
			System.out.println("The method " + methodName + " begins with " + Arrays.asList(pjd.getArgs()));
			//执行目标方法
			result = pjd.proceed();
			//返回通知
			System.out.println("The method " + methodName + " ends with " + result);
		} catch (Throwable e) {
			//异常通知
			System.out.println("The method " + methodName + " occurs exception:" + e);
			throw new RuntimeException(e);
		}
		//后置通知
		System.out.println("The method " + methodName + " ends");
		
		return result;
	}
	*/
   
}
