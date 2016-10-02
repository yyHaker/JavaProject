package com.yy.pattern.factory;

import com.yy.pattern.product.SemiDetacher.MediumSemiDetacher;
import com.yy.pattern.product.SemiDetacher.SemiDetacher;
import com.yy.pattern.product.condo.Condo;
import com.yy.pattern.product.condo.MediumCondo;
import com.yy.pattern.product.house.House;
import com.yy.pattern.product.house.MediumHouse;

public class MediumBuildingFactory extends BuildingFactory {

   public House getHouse(){
      return new MediumHouse();
   }

   public Condo getCondo(){
	  return new MediumCondo();
   }

@Override
public SemiDetacher getSemiDetacher() {
	return new MediumSemiDetacher();
 }
}
