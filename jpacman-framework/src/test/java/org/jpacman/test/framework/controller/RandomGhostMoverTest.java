package org.jpacman.test.framework.controller;

import static org.junit.Assert.assertTrue;

import org.jpacman.framework.controller.AbstractGhostMover;
import org.jpacman.framework.controller.RandomGhostMover;
import org.jpacman.framework.factory.DefaultGameFactory;
import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.factory.MapParser;
import org.jpacman.framework.model.Game;
import org.jpacman.framework.model.Ghost;
import org.jpacman.framework.ui.MainUI;
import org.junit.Test;

public class RandomGhostMoverTest {
	
	//3.5
	
	@Test
	public void testDotick() throws FactoryException {
		MapParser p = new MapParser(new DefaultGameFactory());
		Game game = p.parseMap(new String[]{"P  "," G ","   "});
		Ghost ghost = game.getGhosts().get(0);
		int x = ghost.getTile().getX();
		int y = ghost.getTile().getY();
		
		AbstractGhostMover rgm = new RandomGhostMover(game);
		rgm.start();
		rgm.doTick();
		assertTrue(ghost.getTile().getX() != x || ghost.getTile().getY() != y);
	}

}
