package com.yy.pattern.creator;

import com.yy.pattern.product.AutoInsurance;
import com.yy.pattern.product.Property;


public class PropPolicy implements PolicyProducer {

   public AutoInsurance getInsurObj() {
      return new Property();
   }
}