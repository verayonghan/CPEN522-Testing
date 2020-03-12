package org.jpacman.test.framework.view;

import static org.junit.Assert.assertEquals;

import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.model.Board;
import org.jpacman.framework.view.BoardView;
import org.junit.Test;

public class BoardViewTest {
	
	//3.5
	
	private static final int CELL_HEIGHT = 20;
	public static final int CELL_VGAP = 1;
	
	@Test
	public void testGetWindowHeight() throws FactoryException {
		Board board = new Board(10,10);
		BoardView bv = new BoardView(board);
		
		assertEquals((CELL_HEIGHT + CELL_VGAP) * (board.getHeight() + 1),bv.windowHeight());
	}
}
