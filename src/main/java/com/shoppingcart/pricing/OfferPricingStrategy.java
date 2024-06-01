package com.shoppingcart.pricing;

import java.math.BigDecimal;

class OfferPricingStrategy implements PricingStrategy {
    private final BigDecimal price;
    private final int buyQuantity;
    private final int getQuantity;    

    public OfferPricingStrategy(BigDecimal price, int buyQuantity, int getQuantity) {
        this.price = price;        
        this.buyQuantity = buyQuantity;
        this.getQuantity = getQuantity;
    }

    @Override
    public BigDecimal calculatePrice(int quantity) {
    	int withinOfferPricedItems = (quantity / getQuantity) * buyQuantity;
        int regularPricedItems = quantity % getQuantity;        
        return price.multiply(new BigDecimal(withinOfferPricedItems + regularPricedItems));
    }
}