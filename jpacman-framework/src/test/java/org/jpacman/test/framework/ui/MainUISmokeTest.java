package org.jpacman.test.framework.ui;

import static org.junit.Assert.assertEquals;

import java.awt.Window;

import javax.swing.JFrame;

import org.jpacman.framework.controller.AbstractGhostMover;
import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.ui.ButtonPanel;
import org.jpacman.framework.ui.IPacmanInteraction;
import org.jpacman.framework.ui.MainUI;
import org.jpacman.framework.ui.PacmanInteraction;
import org.jpacman.framework.ui.PointsPanel;
import org.jpacman.framework.view.BoardView;
import org.junit.Test;

/**
 * Smoke test for the main UI: Just start it
 * and interact with it to see if no exceptions are thrown.
 * The bare minimum for any test suite.
 * 
 * @author Arie van Deursen, TU Delft, Feb 4, 2012
 */
public class MainUISmokeTest {
	
	/**
	 * Invoke series of actions on the real game, including the 
	 * real ghost mover.
	 * 
	 * @throws FactoryException If reading board fails.
	 * @throws InterruptedException Since we're timing.
	 */
	@Test
	public void testUIActions() throws FactoryException, InterruptedException {
		MainUI ui = new MainUI();
		ui.initialize();
		ui.start();
		IPacmanInteraction eventHandler = ui.eventHandler();

		// now trigger interesting events.
		eventHandler.start();
		eventHandler.up();
		eventHandler.left();

		// give the ghosts some time to move.
		final int nrOfGhostMovesToWait = 10;
		Thread.sleep(nrOfGhostMovesToWait * AbstractGhostMover.DELAY);

		// and attempt some moves again.
		eventHandler.down();
		eventHandler.stop();
		eventHandler.start();
		eventHandler.right();
		
		// and we're done.
		eventHandler.exit();
	}
	
	
	
	//3.5
	

	/**
	 * Test the method setGridSize()
	 * @throws FactoryException 
	 */
	
	@Test
	public void testSetGridSize() throws FactoryException {
		MainUI ui = new MainUI();
		ui.initialize();
		ui.start();
		
		PointsPanel points = new PointsPanel();
    	points.initialize(ui.getGame().getPointManager());
    	ui.getGame().attach(points);
    	
    	BoardView boardView = new BoardView(ui.getGame().getBoardInspector());
    	
    	ButtonPanel buttonPanel = new ButtonPanel();
    	buttonPanel.initialize();
    	
		assertEquals(ui.getSize().height, points.getHeight() + boardView.windowHeight() + buttonPanel.getHeight());
		assertEquals(ui.getSize().width, Math.max(boardView.windowWidth(), buttonPanel.getWidth()));
	}
	
	/**
	 * Test the withModelInteractor() method
	 */
	@Test
	public void testWithModelInteractor() {
		MainUI ui = new MainUI();
		PacmanInteraction pi = new PacmanInteraction();
		ui = ui.withModelInteractor(pi);
		assertEquals(pi, ui.eventHandler());
	}
}
