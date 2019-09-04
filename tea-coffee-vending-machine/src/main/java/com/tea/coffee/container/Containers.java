package com.tea.coffee.container;

import java.util.HashMap;

public interface Containers {

	public HashMap<String, Integer> teaContainer();

	public HashMap<String, Integer> blackTeaContainer();

	public HashMap<String, Integer> blackCoffeeContainer();

	public HashMap<String, Integer> coffeeContainer();

	public HashMap<String, Integer> sugarContainer();

	public HashMap<String, Integer> waterContainer(Integer waterMaterial, Integer waterWasteMaterial);

	public HashMap<String, Integer> milkContainer(Integer milkMaterial, Integer milkWasteMaterial);
	
	public Boolean resetContainer();

}
