package test;

import static org.junit.Assert.*;

import game.Board;
//import board.Square;

import org.junit.Test;

public class testBoard {
	@Test
	public void test() {
		Board board = new Board();
		assertEquals(board.getSquare(16).toString(),"Palace Gates" );
	}

}
