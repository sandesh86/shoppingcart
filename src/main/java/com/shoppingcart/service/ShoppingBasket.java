package com.shoppingcart.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.shoppingcart.pricing.PricingStrategyFactory;

public class ShoppingBasket {
	public BigDecimal getTotalCost(List<String> itemList) {
		if (itemList == null)  {
			return new BigDecimal(0);
		}
		return itemList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(i -> 1)))
				.entrySet().stream()
				.map(entry -> PricingStrategyFactory.getStrategy(entry.getKey())
						.calculatePrice(entry.getValue()))
				.reduce(new BigDecimal(0), (a, b) -> a.add(b));
	}
}
