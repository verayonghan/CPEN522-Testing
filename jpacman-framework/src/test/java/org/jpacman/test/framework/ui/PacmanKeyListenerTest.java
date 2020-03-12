package org.jpacman.test.framework.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.model.Direction;
import org.jpacman.framework.model.Game;
import org.jpacman.framework.model.Player;
import org.jpacman.framework.model.Tile;
import org.jpacman.framework.ui.MainUI;
import org.jpacman.framework.ui.PacmanInteraction;
import org.jpacman.framework.ui.PacmanKeyListener;
import org.junit.Test;

public class PacmanKeyListenerTest {
	
	
	@Test
	public void testKeyPressed() throws FactoryException, AWTException, InterruptedException {
		
		MainUI ui = new MainUI();
		ui.initialize(); //call addKeyListener(new PacmanKeyListener(pi));
		ui.start();
		
		Robot robot = new Robot();
		
		
		int[] keycodes = {KeyEvent.VK_S, //start
					  KeyEvent.VK_LEFT, //left
					  KeyEvent.VK_RIGHT, //right
					  KeyEvent.VK_H, //left
					  KeyEvent.VK_UP, //up
					  KeyEvent.VK_DOWN, //down
					  KeyEvent.VK_K, //up
					  KeyEvent.VK_J, //down
					  KeyEvent.VK_L, //right
					  KeyEvent.VK_Q, //stop
					  KeyEvent.VK_S, //start
					  KeyEvent.VK_X //exit
					  };
		
		try {
			for (int keycode : keycodes) {
				robot.keyPress(keycode);
				robot.keyRelease(keycode);
				robot.delay(200);
			}
		} catch(Throwable e) {
			fail("Unexpected exception in keyListener");
		}
		
		
		
		//3.5

		// Test keyPressed() method in PacmanKeyListener
		
		Direction[] dirs =  {null, 
							 Direction.LEFT, 
							 Direction.RIGHT, 
							 Direction.LEFT,
							 Direction.UP,
							 Direction.DOWN,
							 Direction.UP,
							 Direction.DOWN,
							 Direction.RIGHT,
							 null,
							 null,
							 null};
		Game g = (Game)ui.getGame();
		Player p = g.getPlayer();
		
		Button a = new Button("click");
		PacmanKeyListener pi = (PacmanKeyListener)ui.getKeyListeners()[0];
		
		for (int i = 0; i < keycodes.length; i++) {
			int keycode = keycodes[i];
	
		    KeyEvent e = new KeyEvent(a, 1, 20, 1, keycode,'a');
			pi.keyPressed(e);
			pi.keyReleased(e);
			
			if (i == 0) { //start
				assertEquals(ui.eventHandler().getCurrentState().toString(),"PLAYING");
			}
			if (i == 9) { //stop
				assertEquals(ui.eventHandler().getCurrentState().toString(),"PAUSING");
			}
			if (i == 10) { //start
				assertEquals(ui.eventHandler().getCurrentState().toString(),"PLAYING");
				
			}
			if (i == 11) { //exit
				assertEquals(ui.eventHandler().getCurrentState().toString(),"PLAYING");
			}
			if (dirs[i] == null) continue;
			assertEquals(p.getDirection().getDx(), dirs[i].getDx());
			assertEquals(p.getDirection().getDy(), dirs[i].getDy());
			
			Thread.sleep(200);
		} 	
	}
}
