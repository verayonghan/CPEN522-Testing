package org.jpacman.test.framework.ui;

import static org.junit.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.ui.MainUI;
import org.junit.Test;

public class PacmanKeyListenerTest {
	
	
	@Test
	public void testKeyPressed() throws FactoryException, AWTException {
		
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
				robot.delay(1000);
			}
		} catch(Throwable e) {
			fail("Unexpected exception in keyListener");
		}
		
	}

}
