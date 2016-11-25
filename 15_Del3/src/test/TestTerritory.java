package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import board.Fleet;
import board.Territory;
import game.Player;

public class TestTerritory {
	private Player p1;
	private Player p2;
	private Territory f1;
	private Territory f2;
	private Territory f3;
	@Before
	public void setUp() {
		p1= new Player ("Spiller1",30000);
		p2= new Player ("Spiller2",30000);
		f1= new Territory("Felt1000",1, 1000, 800);
		f2= new Territory("Felt0",2,0,0);
		f3= new Territory("FeltNeg3000",3,-3000,-2000);
	}

	@After
	public void tearDown() {
		this.p1 = new Player("Spiller1",30000);
		this.p2 = new Player("Spiller2",30000);
		this.f1.clearOwner();
		this.f2.clearOwner();
		this.f3.clearOwner();
		
	}
	@Test
	public void testEntities(){
		Assert.assertNotNull(this.p1);
		Assert.assertNotNull(this.p2);
      	
      	Assert.assertNotNull(this.f1);
      	Assert.assertNotNull(this.f2);
      	Assert.assertNotNull(this.f3);
      	
      	Assert.assertTrue(this.f1 instanceof Territory);
      	Assert.assertTrue(this.f2 instanceof Territory);
      	Assert.assertTrue(this.f3 instanceof Territory);
	}
	@Test
	public void testF1() {
		int expectedP1=30000;
		int actualP1=p1.getBalance();
		int expectedP2=30000;
		int actualP2=p2.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		Assert.assertEquals(p1.returnOwned().size(),0);//tests to see if the list of owned squares is empty
		Assert.assertEquals(expectedP2, actualP2);
		
		f1.landOnSquare(p1);
		f1.landOnSquare(p2);
		
		expectedP1=30000-1000+800;
		actualP1=p1.getBalance();
		expectedP2 = 30000-800;
		actualP2=p2.getBalance();
		assertEquals(expectedP1,actualP1);
		assertEquals(expectedP2,actualP2);
	}
	
	@Test
	public void testF2(){
		int expectedP1=30000;
		int actualP1=p1.getBalance();
		int expectedP2=30000;
		int actualP2=p2.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		Assert.assertEquals(p1.returnOwned().size(),0);//tests to see if the list of owned squares is empty
		Assert.assertEquals(expectedP2, actualP2);
		
		f2.landOnSquare(p1);
		f2.landOnSquare(p2);
		
		assertEquals(expectedP1,actualP1);
		assertEquals(expectedP2,actualP2);
	}
	@Test
	public void testF3(){
		int expectedP1=30000;
		int actualP1=p1.getBalance();
		int expectedP2=30000;
		int actualP2=p2.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		Assert.assertEquals(p1.returnOwned().size(),0);//tests to see if the list of owned squares is empty
		Assert.assertEquals(expectedP2, actualP2);
		
		f3.landOnSquare(p1);
		f3.landOnSquare(p2);
		
		assertEquals(expectedP1,actualP1);
		assertEquals(expectedP2,actualP2);
		
	}

}
