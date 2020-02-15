package org.jpacman.test.framework.model;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.jpacman.framework.model.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class BoardWithinBordersTest {
	
	private Board board;
	private int x, y;
	private boolean isWithin;

	private static final int WIDTH = 10;
	private static final int HEIGHT = 20;
	
	/**
	 * Create a new test case check if within borders at point(x,y)
	 */
	public BoardWithinBordersTest(int x, int y, boolean isWithin) {
		board = new Board(WIDTH, HEIGHT);
		this.x = x;
		this.y = y;
		this.isWithin = isWithin;
	}
	
	/**
	 * Test withinBorders() method
	 */
	@Test
	public void testWithinBorders() {
		assertEquals(isWithin, board.withinBorders(x, y));
	}
	
	/**
	 * One-by-one domain testing
	 * x >= 0 && x < 10 && y >= 0 && y < 20
	 */
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] values = new Object[][] {
			{0,4,true},
			
			{-1,8,false},
			
			{10,12,false},
			
			{9,14,true},
			
			{3,0,true},
			
			{4,-1,false},
			
			{5,20,false},
			
			{6,19,true},
			
			{12,16,false},
			
			{14,22,false},
			
			{7,18,true},
			
			{8,24,false}
		};

		return Arrays.asList(values);
	}
	
	

}
