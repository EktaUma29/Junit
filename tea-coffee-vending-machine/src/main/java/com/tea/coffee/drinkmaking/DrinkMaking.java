package com.tea.coffee.drinkmaking;

import java.util.HashMap;

public interface DrinkMaking {

	Integer teaMaking(Integer QuantityOfTea);

	Integer blackTeaMaking(Integer QuantityOfBlackTea);

	Integer coffeeMaking(Integer QuantityOfCoffee);

	Integer blackCoffeeMaking(Integer QuantityOfBlackCoffee);

	HashMap<String, Integer> totalSaleOfDrinkMaking();

}
