package org.joolzminer.examples.runners;

import java.lang.reflect.Proxy;

import org.joolzminer.examples.patterns.domain.PersonBean;
import org.joolzminer.examples.patterns.domain.PersonBeanImpl;
import org.joolzminer.examples.patterns.proxy.NonOwnerInvocationHandler;
import org.joolzminer.examples.patterns.proxy.OwnerInvocationHandler;

public class MatchMakingRunner {
	
	public static void main(String[] args) {
		
		// Checking OwnerProxy
		PersonBean joePersonBean = getPersonFromDB("Joe Smith");
		PersonBean ownerProxy = getOwnerProxy(joePersonBean);
		System.out.println("Name is " + ownerProxy.getName());
		ownerProxy.setInterests(ownerProxy.getInterests() + ", Chess");
		System.out.println("My interests are " + ownerProxy.getInterests());
		
		try {
			ownerProxy.setHotOrNotRating(1000);
		} catch (Exception e) {
			System.out.println("An exception was caught while trying to update my hotOrNot rating: " + e);
		}
		
		System.out.println("My rating is: " + ownerProxy.getHotOrNotRating());
		
		// Checking NonOwnerProxy
		PersonBean nonOwnerProxy = getNonOwnerProxy(joePersonBean);
		System.out.println("The name is: " + ownerProxy.getName());
		try {
			nonOwnerProxy.setInterests("None");
		} catch (Exception e) {
			System.out.println("An exception was caught while trying to update other user's interests: " + e);
		}
		nonOwnerProxy.setHotOrNotRating(10);
		System.out.println("Joe's rating is: " + nonOwnerProxy.getHotOrNotRating());
		
	}
	
	
	private static PersonBean getPersonFromDB(String personName) {
		PersonBean result = new PersonBeanImpl();
		switch (personName) {
			case "Joe Smith":				
				result.setName("Joe Smith");
				result.setGender("Male");
				result.setInterests("Programming stupid examples, Couch fishing, Shouting");
				result.setHotOrNotRating(5);
				break;
			default:
				throw new IllegalStateException("No data for " + personName + " in the database");
		}
		return result;
	}
	
	private static PersonBean getOwnerProxy(PersonBean personBean) {
		return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(), personBean.getClass().getInterfaces(), new OwnerInvocationHandler(personBean));
	}
	
	private static PersonBean getNonOwnerProxy(PersonBean personBean) {
		return (PersonBean) Proxy.newProxyInstance(personBean.getClass().getClassLoader(), personBean.getClass().getInterfaces(), new NonOwnerInvocationHandler(personBean));
	}
}
