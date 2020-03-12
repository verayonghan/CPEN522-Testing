package org.jpacman.test.framework.model;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.jpacman.framework.factory.DefaultGameFactory;
import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.factory.IGameFactory;
import org.jpacman.framework.factory.MapParser;
import org.jpacman.framework.model.Board;
import org.jpacman.framework.model.Food;
import org.jpacman.framework.model.Game;
import org.jpacman.framework.model.Ghost;
import org.jpacman.framework.model.IBoardInspector.SpriteType;
import org.jpacman.framework.model.IGameInteractor;
import org.jpacman.framework.model.Level;
import org.junit.Test;

public class LevelTest {
	
	//3.5
	
	/**
	 * Test parseMap() method
	 * @throws FactoryException 
	 */
	@Test
	public void testParseMap() throws FactoryException {
		Level l = new Level();
		IGameInteractor g = l.parseMap();
		
		
		IGameFactory factory = new DefaultGameFactory();
		MapParser parser = new MapParser(factory);
		Game g2 = parser.parseFromFile("board.txt");
		assertEquals(g.getGhosts().size(), g2.getGhosts().size());
		
	}
	
	/**
	 * Test getGame() method
	 * @throws FactoryException 
	 */
	@Test
	public void testGetGame() throws FactoryException {
		Level l = new Level();
		IGameInteractor g = l.parseMap();
		assertEquals(g, l.getGame());
	}
	

}
