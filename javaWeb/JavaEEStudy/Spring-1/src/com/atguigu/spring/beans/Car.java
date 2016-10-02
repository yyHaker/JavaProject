package com.atguigu.spring.beans;

public class Car {

	private String company;
	private String brand;
	private int maxSpeed;
	private double price;
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	 

	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Car(String company, String brand, double price) {
		super();
		this.company = company;
		this.brand = brand;
		this.price = price;
	}

	public Car(String company, String brand, int maxSpeed) {
		super();
		this.company = company;
		this.brand = brand;
		this.maxSpeed = maxSpeed;
	}

//	public Car(String company, String brand, int maxSpeed, double price) {
//		super();
//		this.company = company;
//		this.brand = brand;
//		this.maxSpeed = maxSpeed;
//		this.price = price;
//	}

	@Override
	public String toString() {
		return "Car [company=" + company + ", brand=" + brand + ", maxSpeed="
				+ maxSpeed + ", price=" + price + "]";
	}
}
