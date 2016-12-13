package org.joolzminer.examples.test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.joolzminer.examples.patterns.Singleton;
import org.junit.Test;

public class SingletonTest {

	@Test
	public void testSingleton() {

		Singleton singleton1 = Singleton.getInstance(); 
		Singleton singleton2 = Singleton.getInstance();
		
		assertThat(singleton1, is(equalTo(singleton2)));
	}	
}
