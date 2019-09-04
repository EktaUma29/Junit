package com.tea.coffee.drinkmaking;

import static com.tea.coffee.main.ConstantValue.BLACK_COFFEE_COST_TEN;
import static com.tea.coffee.main.ConstantValue.BLACK_TEA_COST_FIVE;
import static com.tea.coffee.main.ConstantValue.COFFEE_COST_FIFTEEN;
import static com.tea.coffee.main.ConstantValue.TEA_COST_TEN;
import static com.tea.coffee.main.ConstantValue.ZERO;

import java.util.HashMap;
import java.util.logging.Logger;

import com.tea.coffee.container.ContainerImp;

public class DrinkMakingImp implements DrinkMaking {
	Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	static Integer teaCost = 0;
	static Integer blackTeaCost = 0;
	static Integer coffeeCost = 0;
	static Integer blackCoffeeCost = 0;
	static Integer totalSale = 0;
	ContainerImp container = new ContainerImp();

	HashMap<String, Integer> totalSaleMap = new HashMap<>();

	@Override
	public Integer teaMaking(Integer quantityOfTea) {
		container.setQuantity(quantityOfTea);
		container.setDrinkType("Tea");
		totalSaleMap.putIfAbsent("Tea", ZERO);
		teaCost = container.teaContainer().get("Tea Cost") * TEA_COST_TEN;
		totalSaleMap.put("Tea", totalSaleMap.get("Tea") + teaCost);
		return teaCost;
	}

	@Override
	public Integer blackTeaMaking(Integer quantityOfBlackTea) {
		container.setQuantity(quantityOfBlackTea);
		container.setDrinkType("Tea");
		totalSaleMap.putIfAbsent("Black Tea", ZERO);
		blackTeaCost = container.blackTeaContainer().get("Black Tea Cost") * BLACK_TEA_COST_FIVE;
		totalSaleMap.put("Black Tea", totalSaleMap.get("Black Tea") + blackTeaCost);
		return blackTeaCost;
	}

	@Override
	public Integer coffeeMaking(Integer quantityOfCoffee) {
		container.setQuantity(quantityOfCoffee);
		container.setDrinkType("Coffee");
		totalSaleMap.putIfAbsent("Coffee", ZERO);
		coffeeCost = container.coffeeContainer().get("Coffee Cost") * COFFEE_COST_FIFTEEN;
		totalSaleMap.put("Coffee", totalSaleMap.get("Coffee") + coffeeCost);
		return coffeeCost;
	}

	@Override
	public Integer blackCoffeeMaking(Integer quantityOfBlackCoffee) {
		container.setQuantity(quantityOfBlackCoffee);
		container.setDrinkType("Coffee");
		totalSaleMap.putIfAbsent("Black Coffee", ZERO);
		blackCoffeeCost = container.blackCoffeeContainer().get("Black Coffee Cost") * BLACK_COFFEE_COST_TEN;
		totalSaleMap.put("Black Coffee", totalSaleMap.get("Black Coffee") + blackCoffeeCost);
		return blackCoffeeCost;
	}

	@Override
	public HashMap<String, Integer> totalSaleOfDrinkMaking() {
		totalSaleMap.putIfAbsent("Tea", ZERO);
		totalSaleMap.putIfAbsent("Black Tea", ZERO);
		totalSaleMap.putIfAbsent("Coffee", ZERO);
		totalSaleMap.putIfAbsent("Black Coffee", ZERO);
		return totalSaleMap;
	}

}
