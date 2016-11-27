package org.joolzminer.examples.patterns.factories;

import org.joolzminer.examples.patterns.domain.Pizza;

public interface PizzaFactory {
	Pizza createPizza(String type);
}
