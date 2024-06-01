package com.shoppingcart.pricing;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class PricingStrategyFactory {
	private final Map<String, PricingStrategy> STRATEGIES = new HashMap<>();
	
	public PricingStrategyFactory(List<PricingStrategy> list) {
		for (PricingStrategy p: list)  {
			STRATEGIES.put(p.getItemName(), p);
		}
	}
	
//	static {
//		// Default pricing strategies for items
//		addStrategy("Apple", new RegularPricingStrategy(new BigDecimal("0.35")));
//		addStrategy("Banana", new RegularPricingStrategy(new BigDecimal("0.20")));
//		addStrategy("Melon", new OfferPricingStrategy(new BigDecimal("0.50"), 1, 2));
//		addStrategy("Lime", new OfferPricingStrategy(new BigDecimal("0.15"), 2, 3));
//	}

	private PricingStrategyFactory() {
	}

	public static PricingStrategy getStrategy(String itemName) {
		return Optional.ofNullable(STRATEGIES.get(itemName)).orElseThrow(() -> new InvalidParameterException(
				String.format("%s Item is not present, please correct your basket list", itemName)));
	}

//	public static void addStrategy(String itemName, PricingStrategy pricingStrategy) {
//		STRATEGIES.put(itemName, pricingStrategy);
//	}
}
