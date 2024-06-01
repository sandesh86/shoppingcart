package com.shoppingcart;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.InvalidParameterException;
import java.util.List;

import com.shoppingcart.service.ShoppingBasket;

public class BasketValueCalculator {

	public static void main(String[] args) {
		List<String> itemList = List.of("Apple", "Apple", "Banana");
		BigDecimal totalCost = calculateBasketCost(itemList);
		System.out.println("Total cost of basket is £" + totalCost);
	}

	public static BigDecimal calculateBasketCost(List<String> itemList) throws InvalidParameterException {
		ShoppingBasket basket = new ShoppingBasket();
		BigDecimal totalCost = basket.getTotalCost(itemList);
		return roundUpWithPrecisionTwo(totalCost);
	}

	private static BigDecimal roundUpWithPrecisionTwo(BigDecimal value) {
		return value.setScale(2, RoundingMode.HALF_UP);
	}
}
