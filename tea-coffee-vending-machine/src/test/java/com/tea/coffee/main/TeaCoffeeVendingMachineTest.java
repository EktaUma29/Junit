
package com.tea.coffee.main;

import static org.mockito.Mockito.when;

import java.util.HashMap;

import static org.mockito.Mockito.verify;
import static com.tea.coffee.main.ConstantValue.ZERO;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tea.coffee.container.ContainerImp;
import com.tea.coffee.drinkmaking.DrinkMakingImp;

@RunWith(MockitoJUnitRunner.class)
public class TeaCoffeeVendingMachineTest {

	@Mock
	DrinkMakingImp drinkMakingImp;

	@Mock
	ContainerImp containerImp;

	@Mock
	ScannerInt scanner;

	@InjectMocks
	TeaCoffeeVendingMachine teaCoffeeVendingMachine;

	@Test
	public void shouldCheckCaseOneForTeaMacking() {
		
		when(scanner.scannerNextInt()).thenReturn(1, 2);
		when(drinkMakingImp.teaMaking(2)).thenReturn(10);
		when(scanner.scannerNext()).thenReturn("n");
		
		teaCoffeeVendingMachine.displayMenuOnConsole();
		
		verify(scanner, times(2)).scannerNextInt();
		verify(scanner, times(1)).scannerNext();
		verify(drinkMakingImp, times(1)).teaMaking(2);
	}
	
	@Test
	public void shouldCheckCaseOneForTeaMackingWhenTeaCostIsZero() {
		when(scanner.scannerNextInt()).thenReturn(1, 0);
		when(drinkMakingImp.teaMaking(0)).thenReturn(0);
		when(scanner.scannerNext()).thenReturn("n");
		
		teaCoffeeVendingMachine.displayMenuOnConsole();
		
		verify(scanner, times(2)).scannerNextInt();
		verify(scanner, times(1)).scannerNext();
		verify(drinkMakingImp, times(1)).teaMaking(0);
	}

	@Test
	public void shouldCheckCaseTwoForBlackTeaMacking() {
		
		when(scanner.scannerNextInt()).thenReturn(2, 2);
		when(scanner.scannerNext()).thenReturn("n");
		when(drinkMakingImp.blackTeaMaking(2)).thenReturn(10);
		
		teaCoffeeVendingMachine.displayMenuOnConsole();
		
		verify(scanner, times(2)).scannerNextInt();
		verify(scanner, times(1)).scannerNext();
		verify(drinkMakingImp, times(1)).blackTeaMaking(2);
		
	}
	
	@Test
	public void shouldCheckCaseTwoForBlackTeaMackingIfTeaCostIsZero() {
		
		when(scanner.scannerNextInt()).thenReturn(2, 0);
		when(scanner.scannerNext()).thenReturn("n");
		when(drinkMakingImp.blackTeaMaking(0)).thenReturn(0);
		
		teaCoffeeVendingMachine.displayMenuOnConsole();
		
		verify(drinkMakingImp).blackTeaMaking(0);
		verify(scanner, times(2)).scannerNextInt();
		verify(scanner, times(1)).scannerNext();
		
	}

	@Test
	public void shouldCheckCaseThreeForCoffeeMacking() {
		
		when(scanner.scannerNextInt()).thenReturn(3, 2);
		when(scanner.scannerNext()).thenReturn("n");
		when(drinkMakingImp.coffeeMaking(2)).thenReturn(20);
		
		teaCoffeeVendingMachine.displayMenuOnConsole();
		
		verify(drinkMakingImp, times(1)).coffeeMaking(2);
		verify(scanner, times(2)).scannerNextInt();
		verify(scanner, times(1)).scannerNext();
		
	}
	
	@Test
	public void shouldCheckCaseThreeForCoffeeMackingIfCoffeeCostIsZero() {
		
		when(scanner.scannerNextInt()).thenReturn(3, 0);
		when(scanner.scannerNext()).thenReturn("n");
		when(drinkMakingImp.coffeeMaking(0)).thenReturn(0);
		
		teaCoffeeVendingMachine.displayMenuOnConsole();
		
		verify(drinkMakingImp, times(1)).coffeeMaking(0);
		verify(scanner, times(2)).scannerNextInt();
		verify(scanner, times(1)).scannerNext();
		
	}

	@Test
	public void shouldCheckCaseFourForBlackCoffeeMacking() {
		
		when(scanner.scannerNextInt()).thenReturn(4, 2);
		when(scanner.scannerNext()).thenReturn("n");
		when(drinkMakingImp.blackCoffeeMaking(2)).thenReturn(10);
		
		teaCoffeeVendingMachine.displayMenuOnConsole();
		
		verify(drinkMakingImp, times(1)).blackCoffeeMaking(2);
		verify(scanner, times(2)).scannerNextInt();
		verify(scanner, times(1)).scannerNext();
		
	}

	@Test
	public void shouldCheckCaseFourForBlackCoffeeIfBlackCoffeeCostZero() {
		
		when(scanner.scannerNextInt()).thenReturn(4, 0);
		when(scanner.scannerNext()).thenReturn("n");
		when(drinkMakingImp.blackCoffeeMaking(0)).thenReturn(0);
		
		teaCoffeeVendingMachine.displayMenuOnConsole();
		
		verify(drinkMakingImp, times(1)).blackCoffeeMaking(0);
		verify(scanner, times(2)).scannerNextInt();
		verify(scanner, times(1)).scannerNext();
		
	}
	
	@Test
	public void shouldCheckCaseFiveForCheckingRefillStatus() {
		
		when(scanner.scannerNextInt()).thenReturn(5);
		when(scanner.scannerNext()).thenReturn("n");
		
		teaCoffeeVendingMachine.displayMenuOnConsole();
		
		verify(scanner, times(1)).scannerNextInt();
		verify(scanner, times(1)).scannerNext();
		
	}

	@Test
	public void shouldCheckCaseSevenForContainerStatus() {
		
		when(scanner.scannerNextInt()).thenReturn(7);
		when(scanner.scannerNext()).thenReturn("n");
		
		teaCoffeeVendingMachine.displayMenuOnConsole();
		
		verify(scanner, times(1)).scannerNextInt();
		verify(scanner, times(1)).scannerNext();
	}
	
	@Test
	public void shouldCheckCaseSixForPrintingTotalSale() {
		HashMap<String, Integer> totalSaleMap = new HashMap<>();
		totalSaleMap.putIfAbsent("Tea", ZERO);
		totalSaleMap.putIfAbsent("Black Tea", ZERO);
		totalSaleMap.putIfAbsent("Coffee", ZERO);
		totalSaleMap.putIfAbsent("Black Coffee", ZERO);
		
		when(scanner.scannerNextInt()).thenReturn(6);
		when(scanner.scannerNext()).thenReturn("n");
		when(drinkMakingImp.totalSaleOfDrinkMaking()).thenReturn(totalSaleMap);
		
		teaCoffeeVendingMachine.displayMenuOnConsole();
		
		verify(scanner, times(1)).scannerNextInt();
		verify(scanner, times(1)).scannerNext();
		verify(drinkMakingImp).totalSaleOfDrinkMaking();
	}

	@Test
	public void shouldCheckCaseEightForResetContainer() {
		
		when(scanner.scannerNextInt()).thenReturn(8);
		when(scanner.scannerNext()).thenReturn("n");
		
		teaCoffeeVendingMachine.displayMenuOnConsole();
		
		verify(scanner, times(1)).scannerNextInt();
		verify(scanner, times(1)).scannerNext();
		
	}

	@Test
	public void shouldCheckCaseDefaultForExitMachine() {
		
		when(scanner.scannerNextInt()).thenReturn(0);
		when(scanner.scannerNext()).thenReturn("n");
		
		teaCoffeeVendingMachine.displayMenuOnConsole();
		
		verify(scanner, times(1)).scannerNextInt();
		verify(scanner, times(1)).scannerNext();
	}

}
