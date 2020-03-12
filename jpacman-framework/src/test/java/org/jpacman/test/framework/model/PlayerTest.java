package org.jpacman.test.framework.model;

import static org.junit.Assert.assertEquals;

import org.jpacman.framework.model.Player;
import org.junit.Test;

public class PlayerTest {
	
	//3.5
	
	/**
	 * Test the addPoints() method
	 */
	@Test
	public void testAddPoints() {
		Player player = new Player();
		assertEquals(10, player.addPoints(10));
	}

}
