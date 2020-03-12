package org.jpacman.test.framework.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.JFrame;

import org.jpacman.framework.controller.AbstractGhostMover;
import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.ui.ButtonPanel;
import org.jpacman.framework.ui.IPacmanInteraction;
import org.jpacman.framework.ui.MainUI;
import org.junit.Test;

/**
 * Smoke test that just creates the button panel.
 * 
 * @author Arie van Deursen, TU Delft, Feb 9, 2012
 */
public class ButtonPanelTest {

	/**
	 * Smoke test that merely creates the panel.
//	 */
	@Test
	public void buttonPanelSmokeTest() {
		JFrame jf = new JFrame();
		ButtonPanel bp = new ButtonPanel().withParent(jf);
		jf.add(bp);
		jf.setVisible(true);
		// next create suitable mocks for the listeners.
		// and then all we need is a gui testing
		// framework allowing us to click...
	}
	
	
	//3.5
	
	
	/**
	 * Test the initialize() method
	 */
	@Test
	public void testInitialize() {
		ButtonPanel bp = new ButtonPanel();
		bp.initialize();
		assertEquals(bp.getWidth(), 3 * BUTTON_WIDTH); //three buttons added in initialize()
	}
	
	
	private final int BUTTON_WIDTH = 80;
	private final int BUTTON_HEIGHT = 45;
	private int buttonCount = 0;
	/**
	 * Test the setPanelSize() method
	 */
	@Test
	public void testPanelSize() {
		ButtonPanel bp = new ButtonPanel();
		bp.setSize(BUTTON_WIDTH * buttonCount, BUTTON_HEIGHT);
		assertEquals(bp.getWidth(), BUTTON_WIDTH * buttonCount);
		assertEquals(bp.getHeight(), BUTTON_HEIGHT);
	}
	

	
	@Test
	public void testButtonPanelActions() {
		MainUI ui = new MainUI();
		try {
			ui.initialize();
			ui.start();
			IPacmanInteraction pi = ui.eventHandler();
			pi.start();
			pi.stop();
			pi.start();
			pi.exit();
			assertTrue(true);
		} catch (FactoryException e) {
			fail("Unexpected FactoryException");
		}

	}
	
}
