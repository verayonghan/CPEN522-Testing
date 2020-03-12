package org.jpacman.test.framework.model;

import static org.junit.Assert.assertEquals;

import org.jpacman.framework.model.Ghost;
import org.jpacman.framework.model.IBoardInspector.SpriteType;
import org.junit.Test;

public class GhostTest {
	
	
	//3.5
	
	/**
	 * Test the getSpriteType()
	 */
	
	@Test
	public void testGetSpriteType() {
		Ghost ghost = new Ghost();
		assertEquals(SpriteType.GHOST, ghost.getSpriteType());
	}

}
