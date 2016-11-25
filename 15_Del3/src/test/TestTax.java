package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import board.Tax;
import board.Square;
import game.Player;

public class TestTax {
	private Player player;
	private Square tax200;
	private Square tax0;
	private Square taxNeg200;

	@Before
	public void setUp() {
		this.player = new Player("Anders And", 1000);
		this.tax200 = new Tax("Helle +200", 1, 200);
		this.tax0 = new Tax("Helle 0", 2, 0);
		this.taxNeg200 = new Tax("Helle -200", 3, -200);
	}

	@After
	public void tearDown() {
		this.player = new Player("Anders And", 1000);
	}

	@Test
	public void testEntities() {
		Assert.assertNotNull(this.player);

		Assert.assertNotNull(this.tax200);
		Assert.assertNotNull(this.tax0);
		Assert.assertNotNull(this.taxNeg200);

		Assert.assertTrue(this.tax200 instanceof Tax);
		Assert.assertTrue(this.tax0 instanceof Tax);
		Assert.assertTrue(this.taxNeg200 instanceof Tax);
	}

	@Test
	public void testTaxAmount200() {
		int expected = 1000;
		int actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.tax200.landOnSquare(this.player);

		expected = 1000 - 200;
		actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testTaxAmount200Twice() {
		int expected = 1000;
		int actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.tax200.landOnSquare(this.player);
		this.tax200.landOnSquare(this.player);

		expected = 1000 - 200 - 200;
		actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testTax0() {
		int expected = 1000;
		int actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.tax0.landOnSquare(this.player);

		expected = 1000;
		actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testTax0Twice() {
		int expected = 1000;
		int actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.tax0.landOnSquare(this.player);
		this.tax0.landOnSquare(this.player);

		expected = 1000;
		actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testTaxNeg200() {
		int expected = 1000;
		int actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.taxNeg200.landOnSquare(this.player);

		// It is not possible to withdraw a negative amount
		expected = 1000;
		actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void testTaxNeg200Twice() {
		int expected = 1000;
		int actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);

		// Perform the action to be tested
		this.taxNeg200.landOnSquare(this.player);
		this.taxNeg200.landOnSquare(this.player);

		// It is still not possible to deposit a negative amount
		expected = 1000;
		actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);

	}
	@Test
	public void testTax10Percent(){
		int expected =1000;
		int actual = this.player.getBalance();
		assertEquals(expected, actual);
		
		this.tax0.landOnSquare(player);
		
		expected = 1000-(1000/10);
		actual = this.player.getBalance();
		Assert.assertEquals(expected, actual);
		//only true if your selected rate:
	}
}
