package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import board.Refuge;
import board.Square;
import game.Player;

public class TestRefuge {
	private Player player;
	private Square refuge200;
	private Square refuge0;
	private Square refugeNeg200;
	
	
	@Before
	public void setUp(){
		this.player = new Player("Anders And",1000);
		this.refuge200 = new Refuge("Helle +200",1,200);
		this.refuge0 = new Refuge("Helle 0",2,0);
		this.refugeNeg200= new Refuge ("Helle -200",3,-200);
	}
	@After
	public void tearDown(){
		this.player= new Player("Anders And",1000);
	}
	
	
	@Test
	public void testEntities() {
		Assert.assertNotNull(this.player);
      	
      	Assert.assertNotNull(this.refuge200);
      	Assert.assertNotNull(this.refuge0);
      	Assert.assertNotNull(this.refugeNeg200);
      	
      	Assert.assertTrue(this.refuge200 instanceof Refuge);
      	Assert.assertTrue(this.refuge0 instanceof Refuge);
      	Assert.assertTrue(this.refugeNeg200 instanceof Refuge);
	}
	
	@Test
	public void testLandOnSquare200(){
		int expected = 1000;
      	int actual = this.player.getBalance();
      	Assert.assertEquals(expected, actual);
      	
      	//Perform the action to be tested
      	this.refuge200.landOnSquare(this.player);
      	
      	expected = 1000 + 200;
      	actual = this.player.getBalance();
      	Assert.assertEquals(expected, actual);
	}
	@Test
   	public void testLandOnField200Twice() {
          	int expected = 1000;
          	int actual = this.player.getBalance();
          	Assert.assertEquals(expected, actual);
 
          	//Perform the action to be tested
          	this.refuge200.landOnSquare(this.player);
          	this.refuge200.landOnSquare(this.player);
          	
          	expected = 1000 + 200 + 200;
          	actual = this.player.getBalance();
          	Assert.assertEquals(expected, actual);
   	}
   	
   	@Test
   	public void testLandOnField0() {
          	int expected = 1000;
          	int actual = this.player.getBalance();
          	Assert.assertEquals(expected, actual);
          	
          	//Perform the action to be tested
          	this.refuge0.landOnSquare(this.player);
          	
          	expected = 1000;
          	actual = this.player.getBalance();
          	Assert.assertEquals(expected, actual);
   	}
   	@Test
   	public void testLandOnField0Twice() {
          	int expected = 1000;
          	int actual = this.player.getBalance();
          	Assert.assertEquals(expected, actual);
 
          	//Perform the action to be tested
          	this.refuge0.landOnSquare(this.player);
          	this.refuge0.landOnSquare(this.player);
          	
          	expected = 1000;
          	actual = this.player.getBalance();
   	   	Assert.assertEquals(expected, actual);
   	}
   	
   	@Test
   	public void testLandOnFieldNeg200() {
          	int expected = 1000;
          	int actual = this.player.getBalance();
          	Assert.assertEquals(expected, actual);
          	
          	//Perform the action to be tested
          	this.refugeNeg200.landOnSquare(this.player);
          	
          	//It is not possible to deposit a negative amount
          	expected = 1000;
          	actual = this.player.getBalance();
          	Assert.assertEquals(expected, actual);
   	}
   	@Test
   	public void testLandOnFieldNeg200Twice() {
          	int expected = 1000;
          	int actual = this.player.getBalance();
          	Assert.assertEquals(expected, actual);
 
          	//Perform the action to be tested
          	this.refugeNeg200.landOnSquare(this.player);
          	this.refugeNeg200.landOnSquare(this.player);
          	
          	//It is still not possible to deposit a negative amount
          	expected = 1000;
          	actual = this.player.getBalance();
          	Assert.assertEquals(expected, actual);
   	}
}

