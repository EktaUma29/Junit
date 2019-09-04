package com.tea.coffee.container;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.tea.coffee.exception.MaterialOverFlowException;
import com.tea.coffee.exception.MaterialUnderFlowException;
import com.tea.coffee.main.ScannerInt;

@RunWith(MockitoJUnitRunner.class)
public class ContainersTest {

	@Mock
	ScannerInt scannerInt;

	@InjectMocks
	ContainerImp containerImp;

	HashMap<String, Integer> capacityOfConatinerExpected = new HashMap<>();
	HashMap<String, Integer> capacityOfConatinerActual = new HashMap<>();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Before
	public void shouldRunBeforeEveryTestCase() {
		containerImp.containerConsumptionMap.clear();
	}

	@Test
	public void shouldReturnRemainingTeaOfTeaContainer() {
		containerImp.setDrinkType("Tea");
		containerImp.setQuantity(2);
		capacityOfConatinerExpected.put("Tea Consumption", 1988);
		capacityOfConatinerActual.put("Tea Consumption", containerImp.teaContainer().get("Tea Consumption"));
		assertEquals(capacityOfConatinerExpected, capacityOfConatinerActual);
	}

	@Test
	public void shouldReturnTheExceptionIfTeaContainerHasNoEnoughTea() {
		containerImp.setDrinkType("Tea");
		containerImp.setQuantity(334);
		containerImp.teaContainer();
		try {
			throw new MaterialUnderFlowException("No Such Amount Of Tea Is Found");
		} catch (MaterialUnderFlowException exception) {
			assertEquals("No Such Amount Of Tea Is Found", exception.getMessage());
		}
	}

	@Test
	public void shouldReturnRemainingTeaOfBlackTeaContainer() {
		containerImp.setDrinkType("Tea");
		containerImp.setQuantity(2);
		capacityOfConatinerExpected.put("Tea Consumption", 1994);
		capacityOfConatinerActual.put("Tea Consumption", containerImp.blackTeaContainer().get("Tea Consumption"));
		assertEquals(capacityOfConatinerExpected, capacityOfConatinerActual);
	}

	@Test
	public void shouldReturnTheExceptionIfTeaContainerHasNoEnoughTeaForBlackTea() {
		containerImp.setDrinkType("Tea");
		containerImp.setQuantity(667);
		containerImp.blackTeaContainer();
		try {
			throw new MaterialUnderFlowException("No Such Amount Of Tea Is Found For Black Tea");
		} catch (MaterialUnderFlowException exception) {
			assertEquals("No Such Amount Of Tea Is Found For Black Tea", exception.getMessage());
		}

	}

	@Test
	public void shouldReturnRemainingCoffeeOfCoffeeContainer() {
		containerImp.setDrinkType("Coffee");
		containerImp.setQuantity(2);
		capacityOfConatinerExpected.put("Coffee Consumption", 1990);
		capacityOfConatinerActual.put("Coffee Consumption", containerImp.coffeeContainer().get("Coffee Consumption"));
		assertEquals(capacityOfConatinerExpected, capacityOfConatinerActual);
	}

	@Test
	public void shouldReturnTheExceptionIfCoffeeContainerHasNoEnoughCoffee() {
		containerImp.setDrinkType("Coffee");
		containerImp.setQuantity(403);
		containerImp.coffeeContainer();
		try {
			throw new MaterialUnderFlowException("No Such Amount Of Coffee Is Found");
		} catch (MaterialUnderFlowException exception) {
			assertEquals("No Such Amount Of Coffee Is Found", exception.getMessage());
		}
	}

	@Test
	public void shouldReturnRemainingCoffeeOFBlackCoffeeContainer() {
		containerImp.setDrinkType("Coffee");
		containerImp.setQuantity(2);
		capacityOfConatinerExpected.put("Coffee Consumption", 1994);
		capacityOfConatinerActual.put("Coffee Consumption",
				containerImp.blackCoffeeContainer().get("Coffee Consumption"));
		assertEquals(capacityOfConatinerExpected, capacityOfConatinerActual);
	}

	@Test
	public void shouldReturnTheExceptionIfCoffeeContainerHasNoEnoughCoffeeForBlackCoffee() {
		containerImp.setDrinkType("Coffee");
		containerImp.setQuantity(667);
		containerImp.blackCoffeeContainer();
		try {
			throw new MaterialUnderFlowException("No Such Amount Of Coffee Is Found");
		} catch (MaterialUnderFlowException exception) {
			assertEquals("No Such Amount Of Coffee Is Found", exception.getMessage());
		}
	}

	@Test
	public void shouldReturnSugarContainer() {
		containerImp.setDrinkType("Tea");
		containerImp.setQuantity(2);
		capacityOfConatinerExpected.put("Sugar Consumption", 7966);
		capacityOfConatinerActual.put("Sugar Consumption", containerImp.sugarContainer().get("Sugar Consumption"));
		assertEquals(capacityOfConatinerExpected, capacityOfConatinerActual);
	}

	@Test
	public void shouldReturnTheExceptionIfSugareContainerHasNoEnoughSugarInSugarContainer() {
		containerImp.setDrinkType("Tea");
		containerImp.setQuantity(3000);
		containerImp.sugarContainer();
		try {
			throw new MaterialUnderFlowException("No Such Amount Of Sugar Is Found");
		} catch (MaterialUnderFlowException exception) {
			assertEquals("No Such Amount Of Sugar Is Found", exception.getMessage());
		}
	}

	@Test
	public void shouldReturnTheExceptionIfMilkContainerHasNoEnoughMilkrInMilkContainer() {
		containerImp.setDrinkType("Coffee");
		containerImp.setQuantity(200);
		containerImp.coffeeContainer();
		containerImp.setDrinkType("Tea");
		containerImp.setQuantity(200);
		containerImp.teaContainer();
		try {
			throw new MaterialUnderFlowException("No Such Amount Of Milk Is Found");
		} catch (MaterialUnderFlowException exception) {
			assertEquals("No Such Amount Of Milk Is Found", exception.getMessage());
		}
	}

	@Test
	public void shouldReturnTheExceptionIfWaterContainerHasNoEnoughWaterInWaterContainer() {
		containerImp.setDrinkType("Coffee");
		containerImp.setQuantity(200);
		containerImp.blackCoffeeContainer();
		containerImp.setDrinkType("Tea");
		containerImp.setQuantity(200);
		containerImp.blackTeaContainer();
		try {
			throw new MaterialUnderFlowException("No Such Amount Of Water Is Found");
		} catch (MaterialUnderFlowException exception) {
			assertEquals("No Such Amount Of Water Is Found", exception.getMessage());
		}
	}

	@Test
	public void shouldCheckCaseOneForRefillTeaContainer() {
		when(scannerInt.scannerNextInt()).thenReturn(1, 0);
		containerImp.checkRefillStatus();
		verify(scannerInt, times(2)).scannerNextInt();
	}

	@Test
	public void shouldCheckCaseTwoForRefillCoffeeContainer() {
		when(scannerInt.scannerNextInt()).thenReturn(2, 0);
		containerImp.checkRefillStatus();
		verify(scannerInt, times(2)).scannerNextInt();
	}

	@Test
	public void shouldCheckCaseThreeForRefillSugarContainer() {
		when(scannerInt.scannerNextInt()).thenReturn(3, 0);
		containerImp.checkRefillStatus();
		verify(scannerInt, times(2)).scannerNextInt();
	}

	@Test
	public void shouldReturnTrueForPrintingConsumptionOfAllMaterials() {
		assertEquals(true, containerImp.totalConsumption());
	}

	@Test
	public void shouldRetrunTrueForResetTheContainer() {
		assertEquals(true, containerImp.resetContainer());
	}

	@Test
	public void shouldCheckCaseFourForRefillWaterContainer() {
		when(scannerInt.scannerNextInt()).thenReturn(4, 0);
		containerImp.checkRefillStatus();
		verify(scannerInt, times(2)).scannerNextInt();
	}

	@Test
	public void shouldCheckCaseFiveForRefillMilkContainer() {
		when(scannerInt.scannerNextInt()).thenReturn(5, 0);
		containerImp.checkRefillStatus();
		verify(scannerInt, times(2)).scannerNextInt();
	}

	@Test
	public void shouldCheckCaseDefaultForRefill() {
		when(scannerInt.scannerNextInt()).thenReturn(0);
		containerImp.checkRefillStatus();
		verify(scannerInt, times(1)).scannerNextInt();
	}

	@Test
	public void shouldThrowExceptionCaseFourForRefillWaterContainer() {
		when(scannerInt.scannerNextInt()).thenReturn(4, 11);
		containerImp.checkRefillStatus();
		try {
			throw new MaterialOverFlowException("Tea Is OverFlow");
		} catch (MaterialOverFlowException exception) {
			assertEquals("Tea Is OverFlow", exception.getMessage());
		}
		verify(scannerInt, times(2)).scannerNextInt();
	}
}
