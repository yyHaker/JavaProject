package com.yy.pattern.factory;

import com.yy.pattern.product.SemiDetacher.SemiDetacher;
import com.yy.pattern.product.SemiDetacher.SuperSemiDetacher;
import com.yy.pattern.product.condo.Condo;
import com.yy.pattern.product.condo.SuperCondo;
import com.yy.pattern.product.house.House;
import com.yy.pattern.product.house.SuperHouse;

public class SuperBuildingFactory extends BuildingFactory {

   public House getHouse(){
      return new SuperHouse();
   }

   public Condo getCondo(){
	  return new SuperCondo();
   }

@Override
public SemiDetacher getSemiDetacher() {
	return new SuperSemiDetacher();
}
}
