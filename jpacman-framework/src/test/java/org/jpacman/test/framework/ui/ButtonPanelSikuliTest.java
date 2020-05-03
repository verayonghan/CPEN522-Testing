package org.jpacman.test.framework.ui;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.ui.MainUI;
import org.junit.Test;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class ButtonPanelSikuliTest {
	
	/**
	 * 
	 * @description Use Sikuli to verify the functionality of button panel including 'start', 'stop', and 'exit' 
	 * @author Yonghan
	 * @date Mar 31, 2020 10:06:38 AM
	 * @throws FactoryException
	 * @throws FindFailed
	 * @throws InterruptedException 
	 */
	@Test
	public void testButtonPanel() throws FactoryException, FindFailed, InterruptedException {
		
		//Pattern - find image
		Pattern activeStart = new Pattern("/Users/vera/Downloads/CPEN522/sikuli/demo/img/active_start.png");
		Pattern activeStop = new Pattern("/Users/vera/Downloads/CPEN522/sikuli/demo/img/active_stop.png");
		Pattern inactiveStart = new Pattern("/Users/vera/Downloads/CPEN522/sikuli/demo/img/inactive_start.png");
		Pattern inactiveStop = new Pattern("/Users/vera/Downloads/CPEN522/sikuli/demo/img/inactive_stop.png");
		Pattern activeExit = new Pattern("/Users/vera/Downloads/CPEN522/sikuli/demo/img/active_exit.png");

		//Start a game
		MainUI ui = new MainUI();
		ui.initialize();
		ui.start();

		//Screen - focus on current screen 
		Screen screen = new Screen(); 
		
		
		//wait for the game getting started, assert the exist of correct button status
		screen.wait(activeStart,5);
		assertNotNull(screen.exists(activeStart));
		assertNotNull(screen.exists(inactiveStop));
		assertNotNull(screen.exists(activeExit));
		
		//click on start button and assert again
		screen.click(activeStart);
		screen.wait(activeStop,5);
		assertNotNull(screen.exists(activeStop));
		assertNotNull(screen.exists(inactiveStart));
		assertNotNull(screen.exists(activeExit));
		
		//click on stop button and assert 
		screen.click(activeStop);
		screen.wait(activeStart,5);
		assertNotNull(screen.exists(activeStart));
		assertNotNull(screen.exists(inactiveStop));
		assertNotNull(screen.exists(activeExit));
		
		//click on exit
		screen.click(activeExit);
		
	}
}
