package com.shoppingcart.pricing;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
class RegularPricingStrategy implements PricingStrategy {
    private final BigDecimal price;
    private final String itemName;

    public RegularPricingStrategy(BigDecimal price, String itemName) {
        this.price = price;
        this.itemName = itemName;
    }

    @Override
    public BigDecimal calculatePrice(int quantity) {
        return price.multiply(new BigDecimal(quantity));
    }

	@Override
	public String getItemName() {
		// TODO Auto-generated method stub
		return itemName;
	}
}