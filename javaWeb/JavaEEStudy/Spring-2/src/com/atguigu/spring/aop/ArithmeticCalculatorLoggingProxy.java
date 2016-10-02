package com.atguigu.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ArithmeticCalculatorLoggingProxy {
	//要代理的对象
	private ArithmeticCalculator target;
	//要代理的对象通过构造方法传进来
	public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
		super();
		this.target = target;
	}

	public ArithmeticCalculator getLoggingProxy(){
		
		ArithmeticCalculator proxy = null;
		
		//代理对象由哪一个类加载器负责加载
		ClassLoader loader = target.getClass().getClassLoader();
		//代理对象的类型，即其中有哪些方法
		Class [] interfaces = new Class[]{ArithmeticCalculator.class};
		
		//当调用代理对象其中的方法时，该执行的代码
		InvocationHandler h = new InvocationHandler() {
			/**
			 * proxy: 正在返回的那个代理对象，一般情况下在invoke方法中都不使用该对象
			 * method: 正在 被调用的方法
			 * args: 调用方法时，传入的参数
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				String methodName = method.getName();
				//1.日志
				System.out.println("[before] The method " + methodName + " begins with " + Arrays.asList(args));
				Object result = null;
				
				try {
					//2.前置通知，执行方法֪
					result = method.invoke(target, args);
					//返回通知，可以访问到方法的返回值
				} catch (NullPointerException e) {
					e.printStackTrace();
					//异常通知，可以访问到方法的异常
				}
			   //3.日志־
				System.out.println("[after] The method ends with " + result);
				return result;
			}
		};
		
		/**
		 * loader: 
		 * interfaces: ָ
		 * h: 
		 */
		proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
	}
}
