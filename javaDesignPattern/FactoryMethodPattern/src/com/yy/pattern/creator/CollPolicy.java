package com.yy.pattern.creator;

import com.yy.pattern.product.AutoInsurance;
import com.yy.pattern.product.Collision;


public class CollPolicy implements PolicyProducer {
    public AutoInsurance getInsurObj() {
        return new Collision();
    }
}
