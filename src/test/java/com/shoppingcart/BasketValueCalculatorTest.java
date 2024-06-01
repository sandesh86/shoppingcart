package com.shoppingcart;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.security.InvalidParameterException;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BasketValueCalculatorTest {

	@ParameterizedTest
	@MethodSource("provideFruitsWithTotal")
	void testCalculateBasketCost(List<String> inputList, BigDecimal expected) {
		assertEquals(expected, BasketValueCalculator.calculateBasketCost(inputList));
	}
	
	@Test
	void testCalculateBasketCost_InvalidItems() {
		assertThrows(InvalidParameterException.class, () -> 
			BasketValueCalculator.calculateBasketCost(List.of("Apple", "Apple", "Banna")), "adsad");
	}
	
	private static Stream<Arguments> provideFruitsWithTotal() {
	    return Stream.of(
	      Arguments.of(List.of("Apple", "Apple", "Banana", "Melon", "Melon", "Melon", "Lime", "Lime", "Lime", "Lime"), 2.35),
	      Arguments.of(List.of("Apple", "Apple", "Banana", "Melon", "Melon", "Lime", "Lime", "Lime"), 1.7),
	      Arguments.of(List.of("Apple", "Apple", "Banana"), 0.90),
	      Arguments.of(List.of(), 0.0),
	      Arguments.of(null, 0.0)
	    );
	}
}
