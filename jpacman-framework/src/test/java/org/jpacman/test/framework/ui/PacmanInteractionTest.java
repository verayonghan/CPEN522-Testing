package org.jpacman.test.framework.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.jpacman.framework.controller.IController;
import org.jpacman.framework.controller.RandomGhostMover;
import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.model.Game;
import org.jpacman.framework.model.IGameInteractor;
import org.jpacman.framework.model.Player;
import org.jpacman.framework.ui.IPacmanInteraction;
import org.jpacman.framework.ui.MainUI;
import org.jpacman.framework.ui.PacmanInteraction;
import org.jpacman.framework.ui.PacmanInteraction.MatchState;
import org.junit.Test;

public class PacmanInteractionTest {
	
	//3.5
	
	@Test
	public void testMatchState() throws FactoryException, InterruptedException {
		MainUI ui = new MainUI();
		ui.initialize();
		ui.start();
		
		PacmanInteraction pi = ui.eventHandler();
		
		assertEquals(pi.getCurrentState().toString(),"PAUSING");
		pi.start();
		assertEquals(pi.getCurrentState().toString(),"PLAYING");
		pi.stop();
		assertEquals(pi.getCurrentState().toString(),"PAUSING");
		pi.start();
		
		
		Game g = (Game)ui.getGame(); 
		Player p = g.getPlayer();
		
		int x = p.getTile().getX();
		int y = p.getTile().getY();
		
		pi.right();
		pi.up();
		
		assertEquals(x+1, p.getTile().getX());
		assertEquals(y-1, p.getTile().getY());
		
		
		
		p.die();
		pi.updateState();
		assertEquals(pi.getCurrentState().toString(),"LOST");
		
		pi.exit();
		assertNotEquals(pi.getCurrentState().toString(),"PAUSING");
		

	
	}       
}
