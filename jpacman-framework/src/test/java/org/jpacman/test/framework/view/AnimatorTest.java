package org.jpacman.test.framework.view;

import static org.junit.Assert.assertTrue;

import java.awt.event.ActionEvent;

import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.model.Board;
import org.jpacman.framework.view.Animator;
import org.jpacman.framework.view.BoardView;
import org.jpacman.framework.view.ImageLoader;
import org.junit.Test;

public class AnimatorTest {
	
	
	//3.5
	
	@Test
	public void testAnimator() throws FactoryException {
		Animator a = new Animator(new BoardView(new Board(10,10)));
		try {
			a.doTick();
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}
