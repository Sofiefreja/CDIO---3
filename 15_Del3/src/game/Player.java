package game;

import java.awt.Color;

public class Player {

	private String name;
	private Account balance = new Account();
	private Vehicle vehicle = new Vehicle();
	
	public Player (String name) {
		this.name = name;
		balance.deposit(30000);
		// Car car = new Car.Builder().typeUfo().primaryColor(getColor()).build(); Skal bruges i GUIControl for createPlayer()
	}
	
	public String toString() {
		return name;
	}
	
	/**
	 * Method for depositing an amount from the player account
	 * @param amount
	 */
	
	public void deposit(int amount) {
		balance.deposit(amount);
	}
	
	/**
	 * Method for withdrawing an amount from the player account
	 * @param amount
	 */
	
	public void pay(int amount) {
		balance.pay(amount);
	}
	
	/**
	 * Method for getting the current account balance of a player
	 * @return Account balance of the type integer
	 */
	
	public int getBalance() {
		return balance.getBalance();
	}
	
	/**
	 * Method for calculating where the player's vehicle lands after rolling the dice
	 * @param roll
	 */
	
	public void moveCar(int roll) {
		vehicle.move(roll);
	}
	
	/**
	 * Method for getting the previous position of the player's vehicle
	 * @return Previous player position of the type integer
	 */
	
	public int getPreviousPosition() {
		return vehicle.getPreviousPosition();
	}
	
	/**
	 * Method for getting the current position of the player's vehicle
	 * @return Player position of the type integer
	 */
	
	public int getCurrentPosition() {
		return vehicle.getCurrentPosition();
	}
	
	/**
	 * Method for setting the position of the player's vehicle
	 * @param position
	 */
	
	public void setPosition(int position) {
		vehicle.setPosition(position);
	}
	
	/**
	 * Method for generating a color used by the 
	 * @return A color of the type Color
	 */
	
	public Color getColor() {
		return vehicle.getColor();
	}
	
	
}
