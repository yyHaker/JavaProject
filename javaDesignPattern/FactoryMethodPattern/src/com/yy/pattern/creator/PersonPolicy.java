package com.yy.pattern.creator;

import com.yy.pattern.product.AutoInsurance;
import com.yy.pattern.product.PersonInjur;


public class PersonPolicy implements PolicyProducer {

   public AutoInsurance getInsurObj() {
      return new PersonInjur();
   }
}
