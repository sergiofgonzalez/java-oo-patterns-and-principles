package org.joolzminer.examples.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.joolzminer.examples.patterns.services.MenuServices;
import org.junit.Test;

public class MenuServicesTest {
	
	@Test
	public void testIsVegetarianExistingNonVegBreakfast() {
		String itemName = "Regular Pancake Breakfast";
		MenuServices menuServices = new MenuServices();
		
		Boolean isVeg = menuServices.isItemVegetarian(itemName);
		
		assertThat(isVeg, is(false));
	}
	
	@Test
	public void testIsVegetarianExistingNonVegLunch() {
		String itemName = "Soup of the day";
		MenuServices menuServices = new MenuServices();
		
		Boolean isVeg = menuServices.isItemVegetarian(itemName);
		
		assertThat(isVeg, is(false));
	}
	
	@Test
	public void testIsVegetarianExistingNonVegCafe() {
		String itemName = "Hotdog";
		MenuServices menuServices = new MenuServices();
		
		Boolean isVeg = menuServices.isItemVegetarian(itemName);
		
		assertThat(isVeg, is(false));
	}

	@Test
	public void testIsVegetarianExistingVegBreakfast() {
		String itemName = "Waffles";
		MenuServices menuServices = new MenuServices();
		
		Boolean isVeg = menuServices.isItemVegetarian(itemName);
		
		assertThat(isVeg, is(true));
	}
	
	
	@Test
	public void testIsVegetarianExistingVegLunch() {
		String itemName = "Vegetarian BLT";
		MenuServices menuServices = new MenuServices();
		
		Boolean isVeg = menuServices.isItemVegetarian(itemName);
		
		assertThat(isVeg, is(true));
	}

	@Test
	public void testIsVegetarianExistingVegCafe() {
		String itemName = "Burrito";
		MenuServices menuServices = new MenuServices();
		
		Boolean isVeg = menuServices.isItemVegetarian(itemName);
		
		assertThat(isVeg, is(true));
	}
	
	@Test
	public void testIsVegetarianNonExistingItem() {
		String itemName = "Veg Pulao";
		
		MenuServices menuServices = new MenuServices();
		
		Boolean isVeg = menuServices.isItemVegetarian(itemName);
		
		assertThat(isVeg, is(nullValue()));
	}
}
