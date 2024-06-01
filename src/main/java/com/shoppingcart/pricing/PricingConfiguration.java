package com.shoppingcart.pricing;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PricingConfiguration {
	
	@Bean
	public RegularPricingStrategy regularPricingStrategy(@Value("${foo.price:0.20}") BigDecimal price)  {
		return new RegularPricingStrategy(price, "Apple");
	}
	
	@Bean
	public RegularPricingStrategy regularPricingBanana()  {
		return new RegularPricingStrategy((new BigDecimal("0.35")), "Banana");
	}


}
