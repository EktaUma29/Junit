package com.tea.coffee.main;

import static com.tea.coffee.main.ConstantValue.SPACE;
import static java.lang.System.exit;

import java.util.HashMap;
import java.util.logging.Logger;

import com.tea.coffee.container.ContainerImp;
import com.tea.coffee.drinkmaking.DrinkMakingImp;

public class TeaCoffeeVendingMachine {

	static Integer quantity = 0;
	static Integer choice = 0;
	static String yesNo = "";
	static HashMap<String, Integer> totalSaleMap;
	static Integer drinkMakingCost = 0;

	ScannerInt scanner = new ScannerInt();

	DrinkMakingImp drinkMaking = new DrinkMakingImp();

	ContainerImp container = new ContainerImp();

	Logger logger = Logger.getLogger(Logger.class.getName());

	public TeaCoffeeVendingMachine() {
		System.setProperty("java.util.logging.SimpleFormatter.format", "%5$s%6$s%n\u001B");
	}

	public static void main(String[] args) {
		TeaCoffeeVendingMachine teaCoffeeVendingMachine = new TeaCoffeeVendingMachine();
		teaCoffeeVendingMachine.displayMenuOnConsole();
	}

	public void displayMenuOnConsole() {
		String userChoice = "y";

		logger.info("\n" + SPACE + "WEL-COME");

		do {

			logger.info(
					"\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
			logger.info(SPACE + "1. Make Tea\n" + SPACE + "2. Make Black Tea\n" + SPACE + "3. Make Coffee\n" + SPACE
					+ "4. Make Black Coffee\n" + SPACE + "5. Refill Container\n" + SPACE + "6. Check Total Sale\n"
					+ SPACE + "7. Container Status\n" + SPACE + "8. Reset Container\n" + SPACE + "9. Exit TCVM ");
			logger.info(
					"\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
			choice = scanner.scannerNextInt();
			switch (choice) {

			case 1:
				logger.info(SPACE + "How many Tea?");
				quantity = scanner.scannerNextInt();
				drinkMakingCost = drinkMaking.teaMaking(quantity);
				logger.info(
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
				if (drinkMakingCost != 0)
					logger.info(SPACE + "Total cost of Tea: " + drinkMakingCost + "");
				logger.info(
						"\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
				logger.info(SPACE + "Do you want to add more Tea or Coffee Y/N?");
				userChoice = scanner.scannerNext();
				break;
			case 2:
				logger.info(SPACE + "How many Black Tea?");
				quantity = scanner.scannerNextInt();
				drinkMakingCost = drinkMaking.blackTeaMaking(quantity);
				logger.info(
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
				if (drinkMakingCost != 0)
					logger.info(SPACE + "Total cost of Black Tea: " + drinkMakingCost + "\n\n");
				logger.info(
						"\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
				logger.info(SPACE + "Do you want to add more Tea or Coffee Y/N?");
				userChoice = scanner.scannerNext();
				break;
			case 3:
				logger.info(SPACE + "How many Coffee?");
				quantity = scanner.scannerNextInt();
				drinkMakingCost = drinkMaking.coffeeMaking(quantity);
				logger.info(
						"\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
				if (drinkMakingCost != 0)
					logger.info(SPACE + "Total cost of Coffee: " + drinkMakingCost + "\n\n");
				logger.info(
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
				logger.info(SPACE + "Do you want to add more Tea or Coffee Y/N?");
				userChoice = scanner.scannerNext();
				break;
			case 4:
				logger.info(SPACE + "How many Black Coffee?");
				quantity = scanner.scannerNextInt();
				drinkMakingCost = drinkMaking.blackCoffeeMaking(quantity);
				logger.info(
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
				if (drinkMakingCost != 0)
					logger.info(SPACE + "Total cost of Coffee: " + drinkMakingCost + "\n\n");
				logger.info(
						"\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
				logger.info(SPACE + "Do you want to add more Tea or Coffee Y/N?");
				userChoice = scanner.scannerNext();
				break;

			case 5:
				container.checkRefillStatus();
				logger.info(SPACE + "Do you want to add more Tea or Coffee Y/N?");
				userChoice = scanner.scannerNext();
				break;
			case 6:
				totalSaleMap = drinkMaking.totalSaleOfDrinkMaking();
				logger.info(
						"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
				logger.info(SPACE + "Total cost of Tea: " + totalSaleMap.get("Tea"));
				logger.info(SPACE + "Total cost of Black Tea: " + totalSaleMap.get("Black Tea"));
				logger.info(SPACE + "Total cost of Coffee: " + totalSaleMap.get("Coffee"));
				logger.info(SPACE + "Total cost of Black Coffee: " + totalSaleMap.get("Black Coffee"));
				logger.info(SPACE + "Total sale: " + (totalSaleMap.get("Tea") + totalSaleMap.get("Black Tea")
						+ totalSaleMap.get("Coffee") + totalSaleMap.get("Black Coffee")));
				logger.info(
						"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n\n");
				logger.info(SPACE + "Do you want to add more Tea or Coffee Y/N?");
				userChoice = scanner.scannerNext();
				break;
			case 7:
				container.totalConsumption();
				logger.info(SPACE + "Do you want to add more Tea or Coffee Y/N?");
				userChoice = scanner.scannerNext();
				break;
			case 8:
				container.resetContainer();
				logger.info(SPACE + "Reset Successfully!\n");
				logger.info(SPACE + "Do you want to add more Tea or Coffee Y/N?");
				userChoice = scanner.scannerNext();
				break;
			case 9:
				logger.info(SPACE + "Please Visit Again");
				exit(0);
				break;
			default:
				logger.info(SPACE + "You have enterd wrong choice please visit again");
				userChoice = scanner.scannerNext();
				break;
			}
		}

		while (userChoice.equalsIgnoreCase("y"));
		logger.info(SPACE + "**Please Visit Again**");

	}

}
