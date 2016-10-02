package com.atguigu.spring.beans;

public class HelloWorld {
    private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	public void Hello(){
		System.out.println("hello: "+name);
	}
}
