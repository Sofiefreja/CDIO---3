package test;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.Arrays;

import org.junit.Test;

import board.Fleet;

import board.LaborCamp;

import game.Player;

public class TestPlayer {

	@Test
	public void test() {
		
		Player p1 = new Player("Simon");
		
		Fleet boat = new Fleet("Boat", 4, 2000);
		
		Fleet carrier = new Fleet("Carrier", 5, 4000);
		
		LaborCamp slavepit = new LaborCamp("Slave Pit", 1, 2000);
		
		LaborCamp quarry = new LaborCamp("Quarry", 2, 2000);
		
		LaborCamp mine = new LaborCamp("Mine", 3, 2000);
		
		assertEquals(p1.toString(),"Simon");
		
		assertEquals(p1.getBalance(),30000);
		
		p1.deposit(10000);
		
		assertEquals(p1.getBalance(),40000);
		
		p1.pay(20000);
		
		assertEquals(p1.getBalance(),20000);
		
		p1.setPosition(5);
		
		assertEquals(p1.getCurrentPosition(), 5);
		
		assertEquals(p1.getPreviousPosition(),0);
		
		p1.moveCar(15);
		
		assertEquals(p1.getCurrentPosition(),20);
		
		assertEquals(p1.getPreviousPosition(),5);
		
		assertEquals(p1.getColor(),Color.blue);
		
		p1.bought(boat);
		
		p1.bought(carrier);
		
		assertEquals(p1.ownedTypes(boat),2);
		
		p1.bought(slavepit);
		
		p1.bought(quarry);
		
		p1.bought(mine);
		
		assertEquals(p1.ownedTypes(mine),3);
		
		int[] TestArray = new int[]{4,5,1,2,3};
		
		assertEquals(Arrays.toString(p1.ownedID()),Arrays.toString(TestArray));

	}

}
