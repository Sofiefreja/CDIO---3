package game;

import java.awt.Color;

public class Vehicle {

	Color carColor = null;
	static int counter = 0;
	private int currentPosition = 0;
	private int previousPosition = 0;
	
	public Vehicle() {
		
		counter++;
		
	}
	
	/**
	 * Method for calculating the new position of a player's vehicle
	 * @param value
	 * @return The new position of the player's vehicle of the type integer
	 */
	
	public int move(int value) {
	
		previousPosition = currentPosition;
		
		currentPosition = (currentPosition+value)%21;
		
		return currentPosition;
		
	}
	
	public void setPosition(int value) {
		currentPosition = value;
	}
	
	public int getPreviousPosition() {
		return previousPosition;
	}
	
	public int getCurrentPosition() {
		return currentPosition;
	}
	
	public Color getColor() {
		
	switch (counter) {
	
	case 1:
		carColor = Color.blue;
		break;
		
	case 2:
		carColor = Color.green;
		break;
		
	case 3:
		carColor = Color.red;
		break;
		
	case 4:
		carColor = Color.pink;
		break;
		
	case 5:
		carColor = Color.black;
		break;
		
	case 6:
		carColor = Color.yellow;
		break;
		
	}
	
	return carColor;
	
}
	
}
