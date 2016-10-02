package com.atguigu.spring.beans.autoware;

public class Person {
     private String name;
     private Car car;
     private Address address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String name, Car car, Address address) {
		super();
		this.name = name;
		this.car = car;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", car=" + car + ", address=" + address
				+ "]";
	}
     
     
}
