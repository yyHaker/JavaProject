package com.yy.pattern.creator;

import com.yy.pattern.product.AutoInsurance;
import com.yy.pattern.product.LuxeryCarInsurance;

public class LuxeryCarPolicyProducer implements PolicyProducer {

	@Override
	public AutoInsurance getInsurObj() {
		
		return new LuxeryCarInsurance();
	}

}
