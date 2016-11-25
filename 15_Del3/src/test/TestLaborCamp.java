package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import game.Player;



public class TestLaborCamp {
	private Player p1;
	private Player p2;
	private FakeLaborCamp aw1;
	private FakeLaborCamp aw2;
	private FakeLaborCamp aw3;
	private FakeLaborCamp aw4;

	@Before
	public void setUp() {
		this.p1 = new Player("p1",30000);
		this.p2 = new Player("p2",30000);
		this.aw1= new FakeLaborCamp("LaborCamp1",1,4000,4,4);
		this.aw2= new FakeLaborCamp("LaborCamp2",2,4000,4,4);
		this.aw3= new FakeLaborCamp("Labor Camp3",3,0,4,4);
		this.aw4= new FakeLaborCamp("Labor Camp4",4,-4000,4,4);
	}
	
	@After
	public void tearDown(){
		this.p1 = new Player("p1",30000);
		this.p2 = new Player("p2",30000);
		this.aw1.clearOwner();
		this.aw2.clearOwner();
		this.aw3.clearOwner();
		this.aw4.clearOwner();
	}
	@Test
	public void testEntities(){
		Assert.assertNotNull(this.p1);
		Assert.assertNotNull(this.p2);
      	
      	Assert.assertNotNull(this.aw1);
      	Assert.assertNotNull(this.aw2);
      	Assert.assertNotNull(this.aw3);
      	Assert.assertNotNull(this.aw4);
      	
      	Assert.assertTrue(this.aw1 instanceof FakeLaborCamp);
      	Assert.assertTrue(this.aw2 instanceof FakeLaborCamp);
      	Assert.assertTrue(this.aw3 instanceof FakeLaborCamp);
      	Assert.assertTrue(this.aw4 instanceof FakeLaborCamp);
	}
	
	@Test
	public void twoCamps(){
		int expectedP1=30000;
		int actualP1=p1.getBalance();
		int expectedP2 = 30000;
		int actualP2 = p2.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		Assert.assertEquals(p1.returnOwned().size(),0);//tests to see if the list of owned squares is empty
		Assert.assertEquals(expectedP2, actualP2);
		
		aw1.landOnSquare(p1);
		aw1.landOnSquare(p2);
		
		expectedP1=30000-4000+800;
		actualP1=p1.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		Assert.assertEquals(p1.returnOwned().size(),1);
		
		expectedP2 =30000-800;
		actualP2=p2.getBalance();
		Assert.assertEquals(expectedP2,actualP2);
		
		
		aw2.landOnSquare(p1);
		aw2.landOnSquare(p2);
		
		expectedP1=30000-4000+800-4000+1600;
		actualP1=p1.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		
		expectedP2 =30000-800-1600;
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
		
		aw3.landOnSquare(p1);
		aw3.landOnSquare(p2);
		
		expectedP1=30000+800;
		actualP1=p1.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		
		expectedP2 =30000-800;
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
		
		aw4.landOnSquare(p1);
		aw4.landOnSquare(p2);
		
		expectedP1=30000+800;
		actualP1=p1.getBalance();
		Assert.assertEquals(expectedP1, actualP1);
		
		expectedP2 =30000-800;
		actualP2=p2.getBalance();
		Assert.assertEquals(expectedP2,actualP2);
		Assert.assertEquals(p1.returnOwned().size(),1);
	}
}
