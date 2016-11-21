package test;

import static org.junit.Assert.*;

import org.junit.Test;
import game.FakeCup;

public class TestCup {
	@Test
	public void TC3(){
		//Tests the methods getEquals, getD1 and getD2.
		FakeCup cup = new FakeCup(5,5);
		
		//tests all the methods with expected outcome.
		assertEquals(cup.roll(), 10);
		assertEquals(cup.getSum(),10);
		assertEquals(cup.getD1(),5);
		assertEquals(cup.getD2(),5);
		assertTrue(cup.getEquals());
		
		FakeCup cup2= new FakeCup(4,6);
		assertFalse(cup2.getEquals());
		assertEquals(cup2.roll(), 10);
		assertEquals(cup2.getSum(),10);
		assertEquals(cup2.getD1(),4);
		assertEquals(cup2.getD2(),6);
	}
}
