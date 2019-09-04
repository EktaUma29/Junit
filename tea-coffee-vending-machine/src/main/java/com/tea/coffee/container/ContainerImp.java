package com.tea.coffee.container;

import static com.tea.coffee.main.ConstantValue.COFFEE_TWO_THOUSAND;
import static com.tea.coffee.main.ConstantValue.EIGHTY;
import static com.tea.coffee.main.ConstantValue.EIGTH;
import static com.tea.coffee.main.ConstantValue.FIFTEEN;
import static com.tea.coffee.main.ConstantValue.FIVE;
import static com.tea.coffee.main.ConstantValue.FOUR;
import static com.tea.coffee.main.ConstantValue.FOURTY;
import static com.tea.coffee.main.ConstantValue.HUNDRED;
import static com.tea.coffee.main.ConstantValue.LINE;
import static com.tea.coffee.main.ConstantValue.MILK_TEN_THOUSAND;
import static com.tea.coffee.main.ConstantValue.ONE;
import static com.tea.coffee.main.ConstantValue.SIXTY;
import static com.tea.coffee.main.ConstantValue.SPACE;
import static com.tea.coffee.main.ConstantValue.SUGAR_EIGTH_THOUSAND;
import static com.tea.coffee.main.ConstantValue.TEA_TWO_THOUSAND;
import static com.tea.coffee.main.ConstantValue.THREE;
import static com.tea.coffee.main.ConstantValue.TWELVE;
import static com.tea.coffee.main.ConstantValue.TWENTY;
import static com.tea.coffee.main.ConstantValue.TWO;
import static com.tea.coffee.main.ConstantValue.WATER_FIFTEEN_THOUSAND;
import static com.tea.coffee.main.ConstantValue.ZERO;

import java.util.HashMap;
import java.util.function.IntFunction;
import java.util.logging.Logger;

import com.tea.coffee.exception.MaterialOverFlowException;
import com.tea.coffee.exception.MaterialUnderFlowException;
import com.tea.coffee.main.ScannerInt;

public class ContainerImp implements Containers {

	private Integer quantity = ZERO;
	private String drinkType = "";

	ScannerInt scanner = new ScannerInt();

	static HashMap<String, Integer> containerConsumptionMap = new HashMap<>();

	Logger logger = Logger.getLogger(Logger.class.getName());

	public ContainerImp() {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%6$s%n\u001B");
	}

	@Override
	public HashMap<String, Integer> teaContainer() {
		quantity = getQuantity();
		drinkType = getDrinkType();
		checkContainerConsumptionMap();
		IntFunction<Integer> intFunction = totalQuantity -> (FIVE * totalQuantity) + (ONE * totalQuantity);
		if (containerConsumptionMap.get(drinkType + " Consumption") >= intFunction.apply(quantity)) {
			containerConsumptionMap.put("Tea Waste", containerConsumptionMap.get("Tea" + " Waste") + (ONE * quantity));
			containerConsumptionMap.put("Tea Consumption",
					containerConsumptionMap.get("Tea Consumption") - intFunction.apply(quantity));
			containerConsumptionMap.put("Tea Cost", quantity);
			sugarContainer();
			milkContainer(FOURTY, FOUR);
			waterContainer(SIXTY, FIVE);
		} else {
			try {
				containerConsumptionMap.put("Tea Cost", ZERO);
				throw new MaterialUnderFlowException("No Such Amount Of Tea Is Found");
			} catch (MaterialUnderFlowException exception) {
				logger.info(SPACE + "Runtime Exception: " + exception.getMessage());
			}
		}

		return containerConsumptionMap;

	}

	@Override
	public HashMap<String, Integer> blackTeaContainer() {
		quantity = getQuantity();
		drinkType = getDrinkType();
		checkContainerConsumptionMap();
		IntFunction<Integer> intFunction = totalQuantity -> (THREE * totalQuantity);
		if (containerConsumptionMap.get(drinkType + " Consumption") >= intFunction.apply(quantity)) {
			containerConsumptionMap.put("Black Tea Cost", quantity);
			containerConsumptionMap.put("Tea Consumption",
					containerConsumptionMap.get("Tea Consumption") - intFunction.apply(quantity));
			sugarContainer();
			waterContainer(HUNDRED, TWELVE);
		} else {
			try {
				containerConsumptionMap.put("Black Tea Cost", ZERO);
				throw new MaterialUnderFlowException("No Such Amount Of Tea Is Found For Black Tea");
			} catch (MaterialUnderFlowException exception) {
				logger.info(SPACE + "Runtime Exception: " + exception.getMessage());
			}
		}

		return containerConsumptionMap;
	}

	@Override
	public HashMap<String, Integer> coffeeContainer() {
		quantity = getQuantity();
		drinkType = getDrinkType();
		checkContainerConsumptionMap();
		IntFunction<Integer> intFunction = totalQuantity -> (FOUR * totalQuantity) + (ONE * totalQuantity);
		if (containerConsumptionMap.get(drinkType + " Consumption") >= intFunction.apply(quantity)) {
			containerConsumptionMap.put("Coffee Waste",
					containerConsumptionMap.get("Coffee" + " Waste") + (ONE * quantity));
			containerConsumptionMap.put("Coffee Consumption",
					containerConsumptionMap.get("Coffee Consumption") - intFunction.apply(quantity));
			containerConsumptionMap.put("Coffee Cost", quantity);
			sugarContainer();
			milkContainer(EIGHTY, EIGTH);
			waterContainer(TWENTY, THREE);
		} else {
			try {
				containerConsumptionMap.put("Coffee Cost", ZERO);
				throw new MaterialUnderFlowException("No Such Amount Of Coffee Is Found");
			} catch (MaterialUnderFlowException exception) {
				logger.info(SPACE + "Runtime Exception: " + exception.getMessage());
			}
		}

		return containerConsumptionMap;
	}

	@Override
	public HashMap<String, Integer> blackCoffeeContainer() {
		quantity = getQuantity();
		drinkType = getDrinkType();
		checkContainerConsumptionMap();
		IntFunction<Integer> intFunction = totalQuantity -> (THREE * totalQuantity);
		if (containerConsumptionMap.get(drinkType + " Consumption") >= intFunction.apply(quantity)) {
			containerConsumptionMap.put("Black Coffee Cost", quantity);
			containerConsumptionMap.put("Coffee Consumption",
					containerConsumptionMap.get("Coffee Consumption") - intFunction.apply(quantity));
			sugarContainer();
			waterContainer(HUNDRED, TWELVE);
		} else {
			try {
				containerConsumptionMap.put("Black Coffee Cost", ZERO);
				throw new MaterialUnderFlowException("No Such Amount Of Coffee Is Found");
			} catch (MaterialUnderFlowException exception) {
				logger.info(SPACE + "Runtime Exception: " + exception.getMessage());
			}
		}

		return containerConsumptionMap;
	}

	@Override
	public HashMap<String, Integer> sugarContainer() {
		quantity = getQuantity();
		drinkType = getDrinkType();
		checkContainerConsumptionMap();

		containerConsumptionMap.putIfAbsent(drinkType, ZERO);
		containerConsumptionMap.putIfAbsent(drinkType + " Waste", ZERO);
		containerConsumptionMap.putIfAbsent("Sugar Waste", ZERO);
		IntFunction<Integer> intFunction = totalQuantity -> (FIFTEEN * totalQuantity) + (TWO * totalQuantity);
		if (containerConsumptionMap.get("Sugar Consumption") >= intFunction.apply(quantity)) {
			containerConsumptionMap.put(drinkType, containerConsumptionMap.get(drinkType) + (FIFTEEN * quantity));
			containerConsumptionMap.put("Sugar Waste", containerConsumptionMap.get("Sugar Waste") + (TWO * quantity));
			containerConsumptionMap.put("Sugar Consumption",
					containerConsumptionMap.get("Sugar Consumption") - intFunction.apply(quantity));
		} else {
			try {
				throw new MaterialUnderFlowException("No Such Amount Of Sugar Is Found");
			} catch (MaterialUnderFlowException exception) {
				logger.info(SPACE + "Runtime Exception: " + exception.getMessage());
			}
		}

		return containerConsumptionMap;
	}

	@Override
	public HashMap<String, Integer> waterContainer(Integer waterMaterial, Integer waterWasteMaterial) {
		containerConsumptionMap.putIfAbsent("Water Waste", ZERO);
		IntFunction<Integer> intFunction = totalQuantity -> (waterMaterial * totalQuantity) + (waterWasteMaterial * totalQuantity);
		if (containerConsumptionMap.get("Water Consumption") >= intFunction.apply(quantity)) {
			containerConsumptionMap.put("Water Waste",
					containerConsumptionMap.get("Water Waste") + (waterWasteMaterial * quantity));
			containerConsumptionMap.put("Water Consumption", containerConsumptionMap.get("Water Consumption")
					- intFunction.apply(quantity));
		} else {
			try {
				throw new MaterialUnderFlowException("No Such Amount Of Water Is Found");
			} catch (MaterialUnderFlowException exception) {
				logger.info(SPACE + "Runtime Exception: " + exception.getMessage());
			}
		}

		return containerConsumptionMap;
	}

	@Override
	public HashMap<String, Integer> milkContainer(Integer milkMaterial, Integer milkWasteMaterial) {
		containerConsumptionMap.putIfAbsent("Milk Waste", ZERO);
		IntFunction<Integer> intFunction = totalQuantity -> (milkMaterial * totalQuantity) + (milkWasteMaterial * totalQuantity);
		if (containerConsumptionMap.get("Milk Consumption") >= intFunction.apply(quantity)) {
			containerConsumptionMap.put("Milk Waste",
					containerConsumptionMap.get("Milk Waste") + (milkWasteMaterial * quantity));
			containerConsumptionMap.put("Milk Consumption", containerConsumptionMap.get("Milk Consumption")
					- intFunction.apply(quantity));
		} else {
			try {
				throw new MaterialUnderFlowException("No Such Amount Of Milk Is Found");
			} catch (MaterialUnderFlowException exception) {
				logger.info(SPACE + "Runtime Exception: " + exception.getMessage());
			}
		}

		return containerConsumptionMap;

	}

	public Boolean totalConsumption() {
		checkContainerConsumptionMap();
		logger.info(LINE);
		logger.info(SPACE + "~~~~~~~~Information About Tea Contatiner~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ SPACE + "\n");
		logger.info(SPACE + "Remaining Tea in container: " + containerConsumptionMap.get("Tea Consumption")
				+ " || Total Tea Waste: " + containerConsumptionMap.get("Tea Waste") + " || Total Tea Refill Count: "
				+ containerConsumptionMap.get("Tea Refill") + "\n\n");
		logger.info(SPACE + "~~~~~~~~Information About Coffee Contatiner~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ SPACE + "\n");
		logger.info(SPACE + "Remaining Coffee in container: " + containerConsumptionMap.get("Coffee Consumption")
				+ " || Total Coffee Waste: " + containerConsumptionMap.get("Coffee Waste")
				+ " || Total Coffee Refill Count: " + containerConsumptionMap.get("Coffee Refill") + "\n\n");
		logger.info(SPACE + "~~~~~~~~Information About Sugar Contatiner~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ SPACE + "\n");
		logger.info(SPACE + "Remaining Sugar in container: " + containerConsumptionMap.get("Sugar Consumption")
				+ " || Total Sugar Waste: " + containerConsumptionMap.get("Sugar Waste")
				+ " || Total Sugar Refill Count: " + containerConsumptionMap.get("Sugar Refill") + "\n\n");
		logger.info(SPACE + "~~~~~~~~Information About Milk Contatiner~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ SPACE + "\n");
		logger.info(SPACE + "Remaining Milk in container: " + containerConsumptionMap.get("Milk Consumption")
				+ " || Total Milk Waste: " + containerConsumptionMap.get("Milk Waste") + " || Total Milk Refill Count: "
				+ containerConsumptionMap.get("Milk Refill") + "\n\n");
		logger.info(SPACE + "~~~~~~~~Information About Water Contatiner~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"
				+ SPACE + "\n");
		logger.info(SPACE + "Remaining Water in container: " + containerConsumptionMap.get("Water Consumption")
				+ " || Total Water Waste: " + containerConsumptionMap.get("Water Waste")
				+ " || Total Water Refill Count: " + containerConsumptionMap.get("Water Refill") + "\n\n");
		logger.info(LINE);
		
		return true;
	}

	public void checkRefillStatus() {
		checkContainerConsumptionMap();

		logger.info(SPACE + "1. Tea Container\n" + SPACE + "2. Coffee Container\n" + SPACE + "3. Sugar Container\n"
				+ SPACE + "4. Water Container\n" + SPACE + "5. Milk Container\n");
		logger.info(SPACE + "Please the choice of refill container");
		Integer choice = scanner.scannerNextInt();
		switch (choice) {
		case 1:
			refillSwitch("Tea", TEA_TWO_THOUSAND);
			break;
		case 2:
			refillSwitch("Coffee", COFFEE_TWO_THOUSAND);
			break;
		case 3:
			refillSwitch("Sugar", SUGAR_EIGTH_THOUSAND);
			break;
		case 4:
			refillSwitch("Water", WATER_FIFTEEN_THOUSAND);
			break;
		case 5:
			refillSwitch("Milk", MILK_TEN_THOUSAND);
			break;
		default:
			logger.info(SPACE + "You have entered wrong container For Refilling Material !!\n");
		}
	}

	public void refillSwitch(String refillDrinkType, Integer containerCapcity) {
		logger.info(SPACE + "Enter amount of " + refillDrinkType + "(in Grams/Millilitre) you want to refill");
		Integer reFillQuantity = 0;
		reFillQuantity = scanner.scannerNextInt();
		if (containerCapcity < containerConsumptionMap.get(refillDrinkType + " Consumption") + reFillQuantity) {
			try {

				throw new MaterialOverFlowException(refillDrinkType + " Is OverFlow\n");
			} catch (MaterialOverFlowException exception) {
				logger.info(SPACE + "Runtime Exception: " + exception.getMessage() + "\n");

			}
		} else {
			logger.info(SPACE + refillDrinkType + " refill" + " of " + reFillQuantity + "gram successfully Done!\n\n");
			containerConsumptionMap.put(refillDrinkType + " Consumption",
					containerConsumptionMap.get(refillDrinkType + " Consumption") + reFillQuantity);
			containerConsumptionMap.put(refillDrinkType + " Refill",
					containerConsumptionMap.get(refillDrinkType + " Refill") + 1);

		}

	}

	public void checkContainerConsumptionMap() {
		containerConsumptionMap.putIfAbsent("Tea Consumption", TEA_TWO_THOUSAND);
		containerConsumptionMap.putIfAbsent("Coffee Consumption", COFFEE_TWO_THOUSAND);
		containerConsumptionMap.putIfAbsent("Sugar Consumption", SUGAR_EIGTH_THOUSAND);
		containerConsumptionMap.putIfAbsent("Water Consumption", WATER_FIFTEEN_THOUSAND);
		containerConsumptionMap.putIfAbsent("Milk Consumption", MILK_TEN_THOUSAND);
		containerConsumptionMap.putIfAbsent("Tea Waste", ZERO);
		containerConsumptionMap.putIfAbsent("Coffee Waste", ZERO);
		containerConsumptionMap.putIfAbsent("Sugar Waste", ZERO);
		containerConsumptionMap.putIfAbsent("Water Waste", ZERO);
		containerConsumptionMap.putIfAbsent("Milk Waste", ZERO);
		containerConsumptionMap.putIfAbsent("Tea Refill", ZERO);
		containerConsumptionMap.putIfAbsent("Coffee Refill", ZERO);
		containerConsumptionMap.putIfAbsent("Sugar Refill", ZERO);
		containerConsumptionMap.putIfAbsent("Water Refill", ZERO);
		containerConsumptionMap.putIfAbsent("Milk Refill", ZERO);
		containerConsumptionMap.putIfAbsent("Tea", ZERO);
		containerConsumptionMap.putIfAbsent("Coffee", ZERO);
		containerConsumptionMap.putIfAbsent("Sugar", ZERO);
		containerConsumptionMap.putIfAbsent("Water", ZERO);
		containerConsumptionMap.putIfAbsent("Milk", ZERO);

	}

	@Override
	public Boolean resetContainer() {
		containerConsumptionMap.clear();
		return true;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDrinkType() {
		return drinkType;
	}

	public void setDrinkType(String drinkType) {
		this.drinkType = drinkType;
	}

}
