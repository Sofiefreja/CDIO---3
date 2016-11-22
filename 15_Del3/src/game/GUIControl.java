package game;

import java.awt.*;
import java.util.ArrayList;
//import board.*;
import desktop_fields.*;
import desktop_fields.Refuge;
//import desktop_fields.Tax;
import desktop_codebehind.*;
import desktop_resources.GUI;
import board.Ownable;
import board.Tax;

public class GUIControl {

	public void makeBoard() { // Method that creates the board for the GUI and
								// sets the squares with their descriptions,
								// colouring and number
		// terr = white, ref = yellow, fleet = blue, tax = red, labor = green.
		Field[] fields = new Field[21];
		fields[0] = new Street.Builder().setTitle("Tribe Encampment").setDescription(".").setSubText(" ").setRent("100")
				.setBgColor(Color.white).setFgColor(Color.white).build();
		fields[1] = new Shipping.Builder().setTitle("Second Sail").setDescription(".").setSubText("+250")
				.setBgColor(Color.blue).setFgColor(Color.blue).build();
		fields[2] = new Street.Builder().setTitle("Crater").setDescription(".").setSubText("-100").setRent("300")
				.setBgColor(Color.white).setFgColor(Color.white).build();
		fields[3] = new Refuge.Builder().setTitle("Walled City").setDescription(".").setSubText("+100")
				.setBgColor(Color.yellow).setFgColor(Color.yellow).build();
		fields[4] = new Street.Builder().setTitle("Huts in the mountain").setDescription(":").setSubText("-20")
				.setBgColor(Color.green).setFgColor(Color.green).build();
		fields[5] = new Street.Builder().setTitle("Mountain").setDescription(".").setSubText("+180").setRent("500")
				.setBgColor(Color.white).setFgColor(Color.white).build();
		fields[6] = new Shipping.Builder().setTitle("Sea Grover").setDescription(".").setSubText("0")
				.setBgColor(Color.blue).setFgColor(Color.blue).build();
		fields[7] = new Street.Builder().setTitle("Cold Desert").setDescription(".").setSubText(".").setRent("700")
				.setBgColor(Color.white).setFgColor(Color.white).build();
		fields[8] = new Street.Builder().setTitle("Black Cave").setDescription(".").setSubText(".").setRent("1000")
				.setBgColor(Color.white).setFgColor(Color.white).build();
		fields[9] = new Street.Builder().setTitle("Goldmine").setDescription(".").setSubText("-80")
				.setBgColor(Color.red).setFgColor(Color.red).build();
		fields[10] = new Street.Builder().setTitle("The Werewall").setDescription(".").setSubText(".").setRent("1300")
				.setBgColor(Color.white).setFgColor(Color.white).build();
		fields[11] = new Street.Builder().setTitle("Mountain Village").setDescription(".").setSubText(".")
				.setRent("1600").setBgColor(Color.blue).setFgColor(Color.red).build();
		fields[12] = new Shipping.Builder().setTitle("The Buccaneers").setDescription(".").setSubText(" ")
				.setBgColor(Color.blue).setFgColor(Color.blue).build();
		fields[13] = new Street.Builder().setTitle("South Citidel").setDescription(".").setSubText("+250")
				.setRent("2000").setBgColor(Color.white).setFgColor(Color.white).build();
		fields[14] = new Refuge.Builder().setTitle("Monestary").setDescription(".").setSubText("-100")
				.setBgColor(Color.yellow).setFgColor(Color.yellow).build();
		fields[15] = new Street.Builder().setTitle("The Pit").setDescription(".").setSubText("+100")
				.setBgColor(Color.green).setFgColor(Color.green).build();
		fields[16] = new Street.Builder().setTitle("Palace Gates").setDescription(".").setSubText("-20").setRent("2600")
				.setBgColor(Color.white).setFgColor(Color.white).build();
		fields[17] = new Shipping.Builder().setTitle("Privateer armada").setDescription(".").setSubText("+180")
				.setBgColor(Color.blue).setFgColor(Color.blue).build();
		fields[18] = new Street.Builder().setTitle("Caravan").setDescription(".").setSubText("0").setBgColor(Color.red)
				.setFgColor(Color.red).build();
		fields[19] = new Street.Builder().setTitle("Tower").setDescription(".").setSubText("-70").setRent("3200")
				.setBgColor(Color.white).setFgColor(Color.white).build();
		fields[20] = new Street.Builder().setTitle("Castle").setDescription(".").setSubText("+60").setRent("4000")
				.setBgColor(Color.white).setFgColor(Color.white).build();
		GUI.create(fields);
	}

	// public void showSquareInfo(Square theSquare) {
	//
	// }

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

	// Creation of players, saving the number of players to an integer and the
	// name of a player as a string in an array.
	public String[] numberOfPlayers() {
		int numberOfPlayers = GUI.getUserInteger("How many players are you? (between 2-6)", 2, 6);
		String[] playerNames = new String[numberOfPlayers];
		for (int i = 1; i <= numberOfPlayers; i++) {
			playerNames[i] = GUI.getUserString(" Player " + i);
		}
		return playerNames;
	}

	// Player choices for each new turn
	public String getUserInputTurn(Player thePlayer) {
		String input;
		input = GUI.getUserButtonPressed(thePlayer.toString() + " it's your turn. Take an action: ", "Roll",
				"Surrender");
		return input;
	}

	// Move vehicle on the board.
	public void moveVehicle(Player thePlayer) {
		thePlayer.getPreviousPosition();
		GUI.removeCar(thePlayer.getPreviousPosition(), thePlayer.toString());
		GUI.setCar(thePlayer.getCurrentPosition(), thePlayer.toString());

	}

	// Extra roll to determine Labor Camp tax.

	public int getUserRoll() {
		int value = 0;
		Cup thecup = new Cup();

		String input = GUI.getUserButtonPressed("You landed on a labor camp, to determine your punishment: ", "Roll");

		if (input.equals("Roll"))
			value = thecup.roll();

		return value;
	}

	// Player choice of buying a square or not.
	public boolean getBuyChoice(Ownable field) {

		String input = GUI.getUserButtonPressed("Buy " + field.toString() + ":", "Yes", "No");
		if (input.equals("Yes"))
			return true;
		else
			return false;
	}

	// Player choice of paying 10% flatrate tax or Tax amount.
	
	public String rateOrAmount(Tax theTax){
		
		String TaxAmount = String.valueOf(theTax.getTaxAmount());
		String output=null;
		
		
		String input = GUI.getUserButtonPressed("You landed on a tax, you have two options: ", "Tax rate 10 %", "Tax Amount "+TaxAmount);
		if (input.equals("Tax rate 10 %"))
			output = "Tax rate";
		else if(input.equals("Tax Amount "+TaxAmount))
	    	output = "Tax Amount";

		return output;
	}
	
	// Removing player from playing board when player surrenders or looses.
	public void removePlayer(Player thePlayer){
		
		
		// Remove the players owned squares.
		int[] list = thePlayer.ownedID();
		
		for (int i = 0; i < list.length; i++){
		GUI.removeOwner(list[i]);
		}
		
		//Remove Car 
		GUI.removeCar(thePlayer.getCurrentPosition(), thePlayer.toString());
		
		
	}
	
	// set square as owned.
	public void setOwned(int squareNumber,Player thePlayer){
		
		GUI.setOwner(squareNumber, thePlayer.toString());
	}
	
		
	

}
