package org.joolzminer.examples.test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Optional;

import org.joolzminer.examples.patterns.services.MenuServices;
import org.junit.Test;

public class MenuServicesTest {
	
	@Test
	public void testIsVegetarianExistingNonVegBreakfast() {
		String itemName = "Regular Pancake Breakfast";
		MenuServices menuServices = new MenuServices();
		
		Optional<Boolean> isVeg = menuServices.isItemVegetarian(itemName);
		
		assertThat(isVeg.get(), is(false));
	}
	
	@Test
	public void testIsVegetarianExistingNonVegLunch() {
		String itemName = "Hotdog";
		MenuServices menuServices = new MenuServices();
		
		Optional<Boolean> isVeg = menuServices.isItemVegetarian(itemName);
		
		assertThat(isVeg.get(), is(false));
	}

	@Test
	public void testIsVegetarianExistingVegBreakfast() {
		String itemName = "Waffles";
		MenuServices menuServices = new MenuServices();
		
		Optional<Boolean> isVeg = menuServices.isItemVegetarian(itemName);
		
		assertThat(isVeg.get(), is(true));
	}
	
	@Test
	public void testIsVegetarianExistingVegLunch() {
		String itemName = "Vegetarian BLT";
		MenuServices menuServices = new MenuServices();
		
		Optional<Boolean> isVeg = menuServices.isItemVegetarian(itemName);
		
		assertThat(isVeg.get(), is(true));
	}
	
	@Test
	public void testIsVegetarianNonExistingItem() {
		String itemName = "Veg Pulao";
		
		MenuServices menuServices = new MenuServices();
		
		Optional<Boolean> isVeg = menuServices.isItemVegetarian(itemName);
		
		assertThat(isVeg, is(Optional.empty()));
	}
}
