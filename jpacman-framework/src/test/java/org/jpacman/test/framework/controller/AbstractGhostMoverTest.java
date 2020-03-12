package org.jpacman.test.framework.controller;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.event.ActionEvent;

import org.jpacman.framework.controller.AbstractGhostMover;
import org.jpacman.framework.controller.RandomGhostMover;
import org.jpacman.framework.factory.DefaultGameFactory;
import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.factory.MapParser;
import org.jpacman.framework.model.Game;
import org.jpacman.framework.model.Ghost;
import org.junit.Test;

public class AbstractGhostMoverTest {
	
	//3.5
	@Test
	public void testAbstractGhostMover() throws FactoryException {
		MapParser p = new MapParser(new DefaultGameFactory());
		Game game = p.parseMap(new String[]{"P  ","   ","   "});
		
		AbstractGhostMover rgm = new RandomGhostMover(game);
		rgm.start();
		
		try {
			rgm.doTick();
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		
		
		ActionEvent ae = new ActionEvent("", 0, null);
		
		try {
			rgm.actionPerformed(ae);
		} catch (Exception e) {
			fail("Unexpected Exception");
		}
		
	}
	
	

}
