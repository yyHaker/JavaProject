package com.yy.pattern.factory;

import com.yy.pattern.product.SemiDetacher.SemiDetacher;
import com.yy.pattern.product.condo.Condo;
import com.yy.pattern.product.house.House;

public abstract class BuildingFactory{
  	public static final String SUPER = "Super Class";
  	public static final String MEDIUM = "Medium Class";

  	public abstract House getHouse();
  	public abstract Condo getCondo();
  	public abstract SemiDetacher getSemiDetacher();

  	public static BuildingFactory getBuildingFactory(String type){
  		 BuildingFactory bf = null;

  		 if (type.equals(BuildingFactory.SUPER)){
			bf = new SuperBuildingFactory();
		 }
  		 else if (type.equals(BuildingFactory.MEDIUM)){
			bf = new MediumBuildingFactory();
		 }

         return bf;
    }
}
