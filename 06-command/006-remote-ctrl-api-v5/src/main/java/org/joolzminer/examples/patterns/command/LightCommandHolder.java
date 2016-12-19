package org.joolzminer.examples.patterns.command;

import java.util.function.Function;

import org.joolzminer.examples.patterns.vendor.Light;

public class LightCommandHolder {
	
	public static Function<Light,Command> lightOnFn = light -> () -> light.on();
	
	public static Function<Light,Command> lightOffFn = light -> () -> light.off();
	
	private LightCommandHolder() {
		// prevent instantiation
	}
}
