package test;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import game.Vehicle;

public class TestVehicle {

	@Test
	public void test() {
		
		Vehicle vehicle = new Vehicle();
		
		vehicle.setPosition(10);
		
		assertEquals(vehicle.getCurrentPosition(),10);
		
		vehicle.move(10);
		
		assertEquals(vehicle.getCurrentPosition(),20);
		assertEquals(vehicle.getPreviousPosition(),10);
		
		vehicle.setPosition(20);
		
		vehicle.move(10);
		
		assertEquals(vehicle.getCurrentPosition(),9);
		
		assertEquals(vehicle.getColor(),Color.blue);
		
		Vehicle vehicle2 = new Vehicle();
		
		assertEquals(vehicle2.getColor(),Color.green);
		
	}

}
