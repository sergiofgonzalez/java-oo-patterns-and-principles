package org.joolzminer.examples.patterns;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChocolateBoiler {
	
	private static final Logger LOGGER =  LoggerFactory.getLogger(ChocolateBoiler.class);
	
	private static ChocolateBoiler uniqueInstance;
	
	private boolean empty;
	private boolean boiled;
	
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	public static ChocolateBoiler getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new ChocolateBoiler();
		}
		return uniqueInstance;
	}
	
	public boolean isEmpty() {
		return empty;
	}

	public boolean isBoiled() {
		return boiled;
	}

	public void fill() {
		LOGGER.debug("Received fill() message");
		if (isEmpty()) {
			LOGGER.debug("Filling the boiler");
			empty = false;
			boiled = false;
		} else {
			LOGGER.debug("Cannot fill an already filled boiler: {}", this);
			throw new IllegalStateException("ChocolateBoiler is already filled");
		}
	}
	
	public void boil() {
		LOGGER.debug("Received boil() message");
		if (!isEmpty() && !isBoiled()) {
			LOGGER.debug("Boiling");
			boiled = true;
		} else {
			LOGGER.debug("Cannot boil if empty or already boiled: {}", this);
			throw new IllegalStateException("ChocolateBoiler is either empty or contents already boiled");
		}
	}

	public void drain() {
		LOGGER.debug("Received drain() message");
		if (!isEmpty() && isBoiled()) {
			LOGGER.debug("Draining");
			empty = true;
		} else {
			LOGGER.debug("Cannot drain if empty or not boiled: {}", this);
			throw new IllegalStateException("ChocolateBoiler is either empty or contents already boiled");
		}
	}
	
	@Override
	public String toString() {
		return "ChocolateBoiler [empty=" + empty + ", boiled=" + boiled + "]";
	}
}
