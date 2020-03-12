package org.jpacman.test.framework.model;

import static org.junit.Assert.assertEquals;

import org.jpacman.framework.model.Food;
import org.jpacman.framework.model.IBoardInspector.SpriteType;
import org.junit.Test;

public class FootTest {
	
	
	//3.5
	
	private final int DEFAULT_POINTS = 10;
	
	/**
	 * Test default points
	 */
	@Test
	public void testGetPoints() {
		Food food = new Food();
		assertEquals(DEFAULT_POINTS, food.getPoints());
		food.setPoints(12);
		assertEquals(12, food.getPoints());
	}

	
	/**
	 * Test the getSpriteType() method
	 */
	@Test
	public void testGetSpriteType() {
		Food food = new Food();
		assertEquals(SpriteType.FOOD, food.getSpriteType());
	}
}
