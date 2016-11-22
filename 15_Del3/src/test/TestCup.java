package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCup {
	@Test
	public void TC3(){
		//Initializes a FakeCup, extended from Cup, which always shows 5 and 5.
		FakeCup cup = new FakeCup(5,5);
		//Tests the methods getEquals, getD1 and getD2.
		assertEquals(cup.roll(), 10);
		assertEquals(cup.getSum(),10);
		assertEquals(cup.getD1(),5);
		assertEquals(cup.getD2(),5);
		assertTrue(cup.getEquals());
		
		//Initializes a new FakeCup, extended from Cup, which always shows 4 and 6.
		//Tests the methods getEquals, getD1 and getD2.
		FakeCup cup2= new FakeCup(4,6);
		assertFalse(cup2.getEquals());
		assertEquals(cup2.roll(), 10);
		assertEquals(cup2.getSum(),10);
		assertEquals(cup2.getD1(),4);
		assertEquals(cup2.getD2(),6);
	}

}
