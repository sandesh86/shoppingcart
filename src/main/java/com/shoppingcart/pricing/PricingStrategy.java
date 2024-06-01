package com.shoppingcart.pricing;

import java.math.BigDecimal;

public interface PricingStrategy {
	BigDecimal calculatePrice(int quantity);
	String getItemName();
}
