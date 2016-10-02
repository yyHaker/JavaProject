package com.yy.pattern.product;

public class LuxeryCarInsurance implements AutoInsurance {
   private String description;
	@Override
	public String getInfo() {
	
	  description="it is the LuxeryCarInsurance";
		return description;
	}

}
