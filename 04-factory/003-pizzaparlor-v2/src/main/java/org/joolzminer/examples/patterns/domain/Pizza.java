package org.joolzminer.examples.patterns.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class Pizza {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Pizza.class);
	
	protected String description;
	
	public String getDescription() {
		return description;
	}	
	
	public void prepare() {
		LOGGER.debug("Pizza.prepare");
	}
	
	public void bake() {
		LOGGER.debug("Pizza.bake");
	}
	
	public void cut() {
		LOGGER.debug("Pizza.cut");
	}
	
	public void box() {
		LOGGER.debug("Pizza.box");
	}	
}
