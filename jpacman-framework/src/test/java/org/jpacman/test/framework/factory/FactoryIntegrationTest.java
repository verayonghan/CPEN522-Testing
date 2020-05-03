package org.jpacman.test.framework.factory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.jpacman.framework.factory.DefaultGameFactory;
import org.jpacman.framework.factory.FactoryException;
import org.jpacman.framework.factory.IGameFactory;
import org.jpacman.framework.factory.MapParser;
import org.jpacman.framework.model.Board;
import org.jpacman.framework.model.Game;
import org.jpacman.framework.model.Food;
import org.jpacman.framework.model.IBoardInspector.SpriteType;
import org.junit.Before;
import org.junit.Test;

/**
 * Test suite addressing collaboration between parser
 * and actual factory.
 * 
 * @author Arie van Deursen, TU Delft, Feb 27, 2012
 */
public class FactoryIntegrationTest {

	private MapParser parser;

	private final String[] map = new String[] { 
			"#####", 
			"#...#", 
			"#GPG#", 
			"#   #",
			"#####" 
	};


	
	/**
	 * Create the standard factory and parser.
	 */
	@Before
	public void setUp() {
		IGameFactory factory = new DefaultGameFactory();
		parser = new MapParser(factory);
	}

	/**
	 * Test parsing of a larger map.
	 * Individual unit tests address specific cases; here we focus
	 * on the overall results.
	 * 
	 * @throws FactoryException If parsing fails. Should not happen.
	 */
	@Test
	public void testFullMap() throws FactoryException {
		Game g = parser.parseMap(map);
		Board b = g.getBoard();

		// did we recognize the right sprites?
		assertEquals(SpriteType.EMPTY, b.spriteTypeAt(1, 3));
		assertEquals(SpriteType.PLAYER, b.spriteTypeAt(2, 2));
		assertEquals(SpriteType.GHOST, b.spriteTypeAt(1, 2));
		assertEquals(SpriteType.WALL, b.spriteTypeAt(0, 0));
		assertEquals(SpriteType.FOOD, b.spriteTypeAt(1, 1));

		// did we properly set the player?
		assertEquals(g.getPlayer(), b.spriteAt(2, 2));

		// were all ghosts added?
		assertEquals(2, g.getGhosts().size());

		// was the food actually added?
		final int cellsWithFoodCount = 3;
		assertEquals(cellsWithFoodCount * Food.DEFAULT_POINTS, 
			     g.getPointManager().totalFoodInGame());
	}
	
	
	
	
	//3.5
	
	private final String[] invalidMap = new String[] {"A"};
	
	/**
	 * Test the invalidSprite() method
	 */
	@Test
	public void testInvalidSprite() {
		try {
			parser.parseMap(invalidMap);
			fail("FactoryException expected");
		} catch (FactoryException e) {
			assertTrue(true);
		}
	}
	
	/**
	 * Test the parseFromFile() method
	 * @throws IOException 
	 * @throws FactoryException 
	 */
	@Test
	public void testParseFromFile() throws IOException, FactoryException {
       
        BufferedWriter writer = new BufferedWriter(new FileWriter("./target/classes/map.txt"));
        for (String s : map) {
        	writer.write(s + "\n");
        }
        writer.close();	
		Game g = parser.parseFromFile("map.txt");
		Board b = g.getBoard();

		// did we recognize the right sprites?
		assertEquals(SpriteType.EMPTY, b.spriteTypeAt(1, 3));
		assertEquals(SpriteType.PLAYER, b.spriteTypeAt(2, 2));
		assertEquals(SpriteType.GHOST, b.spriteTypeAt(1, 2));
		assertEquals(SpriteType.WALL, b.spriteTypeAt(0, 0));
		assertEquals(SpriteType.FOOD, b.spriteTypeAt(1, 1));

		// did we properly set the player?
		assertEquals(g.getPlayer(), b.spriteAt(2, 2));

		// were all ghosts added?
		assertEquals(2, g.getGhosts().size());

		// was the food actually added?
		final int cellsWithFoodCount = 3;
		assertEquals(cellsWithFoodCount * Food.DEFAULT_POINTS, 
			     g.getPointManager().totalFoodInGame());
	}
	
}
