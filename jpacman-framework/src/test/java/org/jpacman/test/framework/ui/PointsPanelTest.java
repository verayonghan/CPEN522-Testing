package org.jpacman.test.framework.ui;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jpacman.framework.model.PointManager;
import org.jpacman.framework.ui.MainUI;
import org.jpacman.framework.ui.PointsPanel;
import org.junit.Test;

public class PointsPanelTest {
	
	
	//3.5
	
	private final int PANEL_HEIGHT = 45;		
	private final int PANEL_WIDTH = 100;
	private final int EATEN_WIDTH = 7;
	
	@Test
	public void testInitialize() {
		
		PointsPanel p = new PointsPanel();
		p.initialize(new PointManager());
		
		
		JTextField field = (JTextField) p.getComponents()[1];
		
		assertEquals(field.getColumns(), EATEN_WIDTH);
		assertEquals(field.getHorizontalAlignment(), SwingConstants.RIGHT);
		assertFalse(field.isEditable());
		
		
		assertEquals(p.getHeight(), PANEL_HEIGHT);
		assertEquals(p.getWidth(), PANEL_WIDTH);
		
		assertEquals(p.getName(),"jpacman.points.panel");
		
	}

}
