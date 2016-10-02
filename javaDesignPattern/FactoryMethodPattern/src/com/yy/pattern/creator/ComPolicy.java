package com.yy.pattern.creator;

import com.yy.pattern.product.AutoInsurance;
import com.yy.pattern.product.ComCover;

public class ComPolicy implements PolicyProducer {
 
    public AutoInsurance getInsurObj() {
        return new ComCover();
    }
}
