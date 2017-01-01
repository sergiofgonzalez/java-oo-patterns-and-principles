package org.joolzminer.examples.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.joolzminer.examples.patterns.domain.PersonBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NonOwnerInvocationHandler implements InvocationHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(NonOwnerInvocationHandler.class);
	
	private PersonBean personBean;
	
	public NonOwnerInvocationHandler(PersonBean personBean) {
		this.personBean = personBean;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		try {
			if (method.getName().startsWith("get")) {
				return method.invoke(personBean, args);
			} else if (method.getName().equals("setHotOrNotRating")) {
				return method.invoke(personBean, args);
			} else if (method.getName().startsWith("set")) {
				throw new IllegalAccessException("You are not allowed to operate personal data of other users");
			}
		} catch (InvocationTargetException e) {
			LOGGER.debug("Error invoking method", e);
		}
		return null;
	}

}
