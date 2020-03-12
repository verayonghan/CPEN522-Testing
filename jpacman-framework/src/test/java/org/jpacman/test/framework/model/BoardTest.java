package org.jpacman.test.framework.model;

import static org.junit.Assert.*;


import org.jpacman.framework.model.Board;
import org.jpacman.framework.model.Direction;
import org.jpacman.framework.model.IBoardInspector.SpriteType;
import org.jpacman.framework.model.Sprite;
import org.jpacman.framework.model.Tile;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	
	private Board board;
	private int x, y;
	private Sprite sprite;
	


	private static final int WIDTH = 10;
	private static final int HEIGHT = 20;
	
	/**
	 * Initial a board with WIDTH and HEIGHT
	 */
	@Before
	public void setUp() {
		board = new Board(WIDTH, HEIGHT);
		x = y = 0;
		sprite = new Sprite() { };
	}
	
	
	/**
	 * Test the constructor with negative width and height
	 */
	@Test(expected = AssertionError.class)
	public void testConstructor() {
		new Board(-10, -20);
	}
	
	
	
	/**
	 * Test the getWidth() method
	 */
	@Test
	public void testGetWidth() {
		assertEquals(WIDTH, board.getWidth());
	}
	
	
	
	/**
	 * Test the getHeight() method
	 */
	@Test
	public void testGetHeight() {
		assertEquals(HEIGHT, board.getHeight());
	}
	
	
	
	/**
	 * Test the put() method by putting a sprite on tile (x,y) within the board
	 */
	@Test
	public void testPutWithinBoard() {
		board.put(sprite, x, y);
		assertEquals(board.tileAt(x, y).topSprite(), sprite);
	}
	
	/**
	 * Test the put() method by putting a sprite on tile out of the  board
	 */
	@Test(expected = AssertionError.class)
	public void testPutOutOfBoard() {
		board.put(sprite, 20, 20);
	}
	
	/**
	 * Test the put() method by putting a sprite = null on tile (x,y) 
	 */
	@Test
	public void testPutNull() {
		Sprite sprite = null;
		AssertionError e = assertThrows(AssertionError.class, ()->board.put(sprite, x, y));
		assertEquals("PRE2: Sprite not null", e.getMessage());
	} 
	
	/**
	 * Test the put() method by putting a sprite that is already on tile
	 */
	@Test
	public void testPutOccupied() {
		board.put(sprite, x, y);
		AssertionError e = assertThrows(AssertionError.class, ()->board.put(sprite, 1, 1));
		assertEquals("PRE3: Sprite should not occupy" + sprite.getTile(), e.getMessage());
	} 
	
	
	
	/**
	 * Test the withinBorders() method 
	 */
	@Test
	public void testWithinBorders() {
		assertTrue(board.withinBorders(0, 0));
		assertFalse(board.withinBorders(WIDTH, HEIGHT));
	}
	
	
	
	/**
	 * Test the spriteAt() method within board
	 */
	@Test
	public void testSpriteAt() {
		board.put(sprite, x, y);
		assertEquals(sprite, board.spriteAt(x, y));
	}
	
	/**
	 * Test the spriteAt() method out of board
	 */
	@Test(expected = AssertionError.class)
	public void testSpriteAtOutOfBoard() {
		board.spriteAt(20, 20);
	}
	
	
	
	/**
	 * Test the spriteTypeAt() method within board
	 */
	@Test
	public void testSpriteTypeAt() {
		board.put(sprite, x, y);
		assertEquals(sprite.getSpriteType(), board.spriteTypeAt(x, y));
	}
	
	/**
	 * Test the spriteTypeAt() method out of board
	 */
	@Test(expected = AssertionError.class)
	public void testSpriteTypeAtOutOfBoard() {
		board.spriteTypeAt(20, 20);
	}
	
	/**
	 * Test the spriteTypeAt() method with empty sprite
	 */
	@Test
	public void testEmptySpriteType() {
		assertEquals(SpriteType.EMPTY, board.spriteTypeAt(x, y));
	}
	
	
	
	/**
	 * Test the tileAt() method within board
	 */
	@Test
	public void testTileAt() {
		Tile tile = board.tileAt(x, y);
		assertEquals(x, tile.getX());
		assertEquals(y, tile.getY());
	}
	
	/**
	 * Test the tileAt() method out of board
	 */
	@Test(expected = AssertionError.class)
	public void testTileAtOutOfBoard() {
		board.tileAt(20, 20);
	}
	
	
	
	/**
	 * Test the tileAtOffSide() method 
	 */
	@Test
	public void testTileAtOffSide() {
		Tile start = board.tileAt(x,y);
		Tile actual = board.tileAtOffset(start, 1, 1);
		Tile desired = board.tileAt(x+1, y+1);
		
		assertEquals(actual, desired);
	}
	
	
	
	/**
	 * Test the tileAtDirection() method 
	 */
	@Test
	public void testTileAtDirection() {
		Tile start = board.tileAt(x, y);
		Tile actual = board.tileAtDirection(start, Direction.RIGHT);
		Tile desired = board.tileAt(x+1, y);
		assertEquals(actual,desired);
	}
	
}

