package org.jpacman.test.framework.factory;

import static org.junit.Assert.assertEquals;
import org.jpacman.framework.factory.FactoryException;
import org.junit.Test;

public class FactoryExceptionTest {
	 
	/**
	* Test FactoryException constructor with message
	*/
	 @Test
	 public void testConstructorWithMes(){ 
		String message = "Factory exception message";
		try {
			FactoryException f = new FactoryException(message);
		} catch(RuntimeException e) {
			assertEquals(message, e.getMessage());
		}
	 }
	
	/**
	* Test FactoryException constructor with message and cause
	*/
	 @Test
	 public void testConstructorWithMesCause(){
		String message = "Factory exception message";
		Throwable cause = new Throwable();
		try {
			FactoryException f = new FactoryException(message, cause);
		} catch(RuntimeException e) {
			assertEquals(message, e.getMessage());
			assertEquals(cause, e.getCause());
		}
	 }
}
