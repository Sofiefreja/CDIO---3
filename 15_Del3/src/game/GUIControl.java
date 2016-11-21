package game;

import java.awt.*;
import desktop_fields.*;
import desktop_codebehind.*;
import desktop_resources.GUI;
import desktop_resources.GUI.*;


public class GUIControl {

	
public void makeBoard() { // Method that creates the board for the GUI and sets the squares with their descriptions, colouring and number
	Field[] fields = new Field[21];
	fields[0] = new Street.Builder().setTitle("Begin").setDescription("This is where the game begins.")
			.setSubText(" ").setBgColor(Color.yellow).setFgColor(Color.green).build();
	fields[1] = new Shipping.Builder().setTitle("Tower").setDescription("You entered the tower. You are awarded:")
			.setSubText("+250").setBgColor(Color.blue).setFgColor(Color.red).build();
	fields[2] = new Street.Builder().setTitle("Crater").setDescription("You fell into the crater. You lose:")
			.setSubText("-100").setBgColor(Color.red).setFgColor(Color.blue).build();
	fields[3] = new Refuge.Builder().setTitle("Palace Gates").setDescription("You are standing at the palace gates. You are awarded:")
			.setSubText("+100").setBgColor(Color.blue).setFgColor(Color.red).build();
	fields[4] = new Tax.Builder().setTitle("Cold Desert").setDescription("You entered the cold desert. You lose:")
			.setSubText("-20").setBgColor(Color.red).setFgColor(Color.blue).build();
	fields[5] = new Street.Builder().setTitle("Walled City").setDescription("You have reached Walled city! You are awarded:")
			.setSubText("+180").setBgColor(Color.blue).setFgColor(Color.red).build();
	fields[6] = new Shipping.Builder().setTitle("Monastery").setDescription("You entered the Monastery. Nothing happens..")
			.setSubText("0").setBgColor(Color.red).setFgColor(Color.blue).build();
	fields[7] = new Street.Builder().setTitle("Black Cave").setDescription("You were pushed into a black cave. You lose:")
			.setSubText("-70").setBgColor(Color.blue).setFgColor(Color.red).build();
	fields[8] = new Street.Builder().setTitle("Huts in the mountain").setDescription("You got to the wonderful huts in the mountain. You are awarded:")
			.setSubText("+60").setBgColor(Color.red).setFgColor(Color.blue).build();
	fields[9] = new Tax.Builder().setTitle("The Werewall").setDescription("You have reached the feared Werewall. You gain another turn, however you lose:")
			.setSubText("-80").setBgColor(Color.blue).setFgColor(Color.red).build();
	fields[10] = new Street.Builder().setTitle("The pit").setDescription("You stumbled into the pit. You lose:")
			.setSubText("-50").setBgColor(Color.red).setFgColor(Color.blue).build();
	fields[11] = new Street.Builder().setTitle("Goldmine").setDescription("You found the goldmine! You are rich!!! You gain:")
			.setSubText("+650").setBgColor(Color.blue).setFgColor(Color.red).build();
	fields[12] = new Shipping.Builder().setTitle("Begin").setDescription("This is where the game begins.")
			.setSubText(" ").setBgColor(Color.yellow).setFgColor(Color.green).build();
	fields[13] = new Street.Builder().setTitle("Tower").setDescription("You entered the tower. You are awarded:")
			.setSubText("+250").setBgColor(Color.blue).setFgColor(Color.red).build();
	fields[14] = new Refuge.Builder().setTitle("Crater").setDescription("You fell into the crater. You lose:")
			.setSubText("-100").setBgColor(Color.red).setFgColor(Color.blue).build();
	fields[15] = new Tax.Builder().setTitle("Palace Gates").setDescription("You are standing at the palace gates. You are awarded:")
			.setSubText("+100").setBgColor(Color.blue).setFgColor(Color.red).build();
	fields[16] = new Street.Builder().setTitle("Cold Desert").setDescription("You entered the cold desert. You lose:")
			.setSubText("-20").setBgColor(Color.red).setFgColor(Color.blue).build();
	fields[17] = new Shipping.Builder().setTitle("Walled City").setDescription("You have reached Walled city! You are awarded:")
			.setSubText("+180").setBgColor(Color.blue).setFgColor(Color.red).build();
	fields[18] = new Street.Builder().setTitle("Monastery").setDescription("You entered the Monastery. Nothing happens..")
			.setSubText("0").setBgColor(Color.red).setFgColor(Color.blue).build();
	fields[19] = new Street.Builder().setTitle("Black Cave").setDescription("You were pushed into a black cave. You lose:")
			.setSubText("-70").setBgColor(Color.blue).setFgColor(Color.red).build();
	fields[20] = new Street.Builder().setTitle("Huts in the mountain").setDescription("You got to the wonderful huts in the mountain. You are awarded:")
			.setSubText("+60").setBgColor(Color.red).setFgColor(Color.blue).build();
	GUI.create(fields);
	}

	public void showSquareInfo(Square theSquare) {

	}

	public void showWinner(Player winner) {
		GUI.showMessage("Congratulations " + winner + "! " + "You are the winner!");
	}

	public void createPlayer(Player newPlayer) {

		// Creating the car.
		Car car = new Car.Builder().typeUfo().patternFill().primaryColor(newPlayer.getColor()).build();
		// Creating player on board.
		GUI.addPlayer(newPlayer.toString(), newPlayer.getBalance(), car);
	}

	// Getting dice value, printing to GUI
	public void showDice(Cup newCup) {
		int d1 = newCup.getD1();
		int d2 = newCup.getD2();
		GUI.setDice(d1, d2);
	}
	// Creation of players, saving the number of players to an integer and the name of a player as a string in an array.
	public String[] numberOfPlayers()
	{
	int numberOfPlayers = GUI.getUserInteger("How many players are you (between 2-6)", 2, 6);
	String[] playerNames = new String[numberOfPlayers];
	for (int i=1; i<=numberOfPlayers; i++)
	{
	playerNames[i] = GUI.getUserString(" Player " +i);
	}
	return playerNames;	
	}
	
	//Player choices for the new turn
	public String getUserInputTurn(Player thePlayer){
	String input;
	input = GUI.getUserButtonPressed(thePlayer.toString() + " it's your turn. Take an action: ", "Roll", "Surrender");
		return input;		
	}
	
	
	//Moves vehicle on board.
	public void moveVehicle(Player thePlayer){
		thePlayer.getPreviousPosition();
		GUI.removeCar(thePlayer.getPreviousPosition(), thePlayer.toString());
		GUI.setCar(thePlayer.getCurrentPosition(), thePlayer.toString());
		
	}
}
