package com.tea.coffee.drinkmaking;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DrinkMakingTest {

	@Mock
	DrinkMaking drinkMaking;

	@InjectMocks
	DrinkMakingImp drinkMakingImp;

	HashMap<String, Integer> totalSaleExpect = new HashMap<>();
	HashMap<String, Integer> totalSaleActual;
	static Integer costOfTea;
	static Integer costOfBlackTea;
	static Integer costOfCoffee;
	static Integer costOfBlackCoffee;

	@Test
	public void shouldReturnTotalCostOfTea() {
		costOfTea = drinkMakingImp.teaMaking(2);
		assertEquals(new Integer(20), costOfTea);
	}

	@Test
	public void shouldReturnTotalCostOfBlackTea() {
		costOfBlackTea = drinkMakingImp.blackTeaMaking(2);
		assertEquals(new Integer(10), costOfBlackTea);
	}

	@Test
	public void shouldReturnTotalCostOfCoffee() {
		costOfCoffee = drinkMakingImp.coffeeMaking(2);
		assertEquals(new Integer(30), costOfCoffee);
	}

	@Test
	public void shouldReturnTotalCostOfBlackCoffee() {
		costOfBlackCoffee = drinkMakingImp.blackCoffeeMaking(2);
		assertEquals(new Integer(20), costOfBlackCoffee);
	}

	@Test
	public void shouldReturnTotalCostOfTeaAndCoffee() {
		drinkMakingImp.teaMaking(2);
		drinkMakingImp.blackTeaMaking(2);
		drinkMakingImp.coffeeMaking(2);
		drinkMakingImp.blackCoffeeMaking(2);
		totalSaleActual = drinkMakingImp.totalSaleOfDrinkMaking();
		totalSaleExpect.put("Tea", 20);
		totalSaleExpect.put("Black Tea", 10);
		totalSaleExpect.put("Coffee", 30);
		totalSaleExpect.put("Black Coffee", 20);
		assertEquals(totalSaleExpect, totalSaleActual);
	}

}
