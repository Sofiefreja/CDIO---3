package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import board.Fleet;
import board.Fleet;
import game.Player;

public class TestFleet {
	private Player p1;
	private Player p2;
	private Fleet boat1;
	private Fleet boat2;
	private Fleet boat3;
	private Fleet boat4;

	@Before
	public void setUp() {
		this.p1 = new Player("p1",30000);
		this.p2 = new Player("p2",30000);
		this.boat1= new Fleet("Fleet1",1,4000);
		this.boat2= new Fleet("Fleet2",2,4000);
		this.boat3= new Fleet("Fleet3",3,0);
		this.boat4= new Fleet("Fleet4",4,-4000);
	}
	
	@After
	public void tearDown(){
		this.p1 = new Player("p1",30000);
		this.p2 = new Player("p2",30000);
		this.boat1.clearOwner();
		this.boat2.clearOwner();
		this.boat3.clearOwner();
		this.boat4.clearOwner();
	}
	@Test
	public void testEntities(){
		Assert.assertNotNull(this.p1);
		Assert.assertNotNull(this.p2);
      	
      	Assert.assertNotNull(this.boat1);
      	Assert.assertNotNull(this.boat2);
      	Assert.assertNotNull(this.boat3);
      	Assert.assertNotNull(this.boat4);
      	
      	Assert.assertTrue(this.boat1 instanceof Fleet);
      	Assert.assertTrue(this.boat2 instanceof Fleet);
      	Assert.assertTrue(this.boat3 instanceof Fleet);
      	Assert.assertTrue(this.boat4 instanceof Fleet);
	}
	
	@Test
	public void twoBoats(){
		int expectedP1=30000;
		int actualP1=p1.getBalance();
		int expectedP2 = 30000;
		int actualP2 = p2.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		Assert.assertEquals(p1.returnOwned().size(),0);//tests to see if the list of owned squares is empty
		Assert.assertEquals(expectedP2, actualP2);
		
		boat1.landOnSquare(p1);
		boat1.landOnSquare(p2);
		
		expectedP1=30000-4000+500;
		actualP1=p1.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		Assert.assertEquals(p1.returnOwned().size(),1);
		
		expectedP2 =30000-500;
		actualP2=p2.getBalance();
		Assert.assertEquals(expectedP2,actualP2);
		
		
		boat2.landOnSquare(p1);
		boat2.landOnSquare(p2);
		
		expectedP1=30000-4000+500-4000+1000;
		actualP1=p1.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		
		expectedP2 =30000-500-1000;
		actualP2=p2.getBalance();
		Assert.assertEquals(expectedP2,actualP2);
		Assert.assertEquals(p1.returnOwned().size(),2);
		
	}
	@Test
	public void testPriceZero(){
		int expectedP1=30000;
		int actualP1=p1.getBalance();
		int expectedP2 = 30000;
		int actualP2 = p2.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		Assert.assertEquals(p1.returnOwned().size(),0);//tests to see if the list of owned squares is empty
		Assert.assertEquals(expectedP2, actualP2);
		
		boat3.landOnSquare(p1);
		boat3.landOnSquare(p2);
		
		expectedP1=30000+500;
		actualP1=p1.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		
		expectedP2 =30000-500;
		actualP2=p2.getBalance();
		Assert.assertEquals(expectedP2,actualP2);
		Assert.assertEquals(p1.returnOwned().size(),1);
	}
	@Test
	public void testNegPrice(){
		int expectedP1=30000;
		int actualP1=p1.getBalance();
		int expectedP2 = 30000;
		int actualP2 = p2.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		Assert.assertEquals(p1.returnOwned().size(),0);//tests to see if the list of owned squares is empty
		Assert.assertEquals(expectedP2, actualP2);
		
		boat4.landOnSquare(p1);
		boat4.landOnSquare(p2);
		
		expectedP1=30000+500;
		actualP1=p1.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		
		expectedP2 =30000-500;
		actualP2=p2.getBalance();
		Assert.assertEquals(expectedP2,actualP2);
		Assert.assertEquals(p1.returnOwned().size(),1);
	}
}
