package com.yy.pattern.creator;

import com.yy.pattern.product.AutoInsurance;
import com.yy.pattern.product.BodyInjur;

public class BodyPolicy implements PolicyProducer {
    public AutoInsurance getInsurObj() {
       return new BodyInjur();
    }
}
