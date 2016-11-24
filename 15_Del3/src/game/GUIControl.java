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
		// terr = white, ref = green, fleet = blue, tax = red, labor = yellow.
		Field[] fields = new Field[21];
		fields[0] = new Street.Builder().setTitle("Tribe Encampment").setDescription("Territory").setSubText("Price: 1000").setRent("100")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[1] = new Shipping.Builder().setTitle("Second Sail").setDescription("Fleet").setSubText("Price: 4000")
				.setBgColor(Color.blue).setFgColor(Color.white).build();
		fields[2] = new Street.Builder().setTitle("Crater").setDescription("Territory").setSubText("Price: 1500").setRent("300")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[3] = new Street.Builder().setTitle("Walled City").setDescription("Refuge").setSubText("Reward: 5000")
				.setBgColor(Color.green).setFgColor(Color.black).build();
		fields[4] = new Street.Builder().setTitle("Huts in the mountain").setDescription("Labor Camp").setSubText("Punishment: Eyes x 100")
				.setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[5] = new Street.Builder().setTitle("Mountain").setDescription("Territory").setSubText("Price: 2000").setRent("500")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[6] = new Shipping.Builder().setTitle("Sea Grover").setDescription("Fleet").setSubText("Price: 4000")
				.setBgColor(Color.blue).setFgColor(Color.white).build();
		fields[7] = new Street.Builder().setTitle("Cold Desert").setDescription("Territory").setSubText("Price: 3000").setRent("700")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[8] = new Street.Builder().setTitle("Black Cave").setDescription("Territory").setSubText("Price: 4000").setRent("1000")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[9] = new Street.Builder().setTitle("Goldmine").setDescription("Tax").setSubText("2000 or 10% of balance tax!")
				.setBgColor(Color.red).setFgColor(Color.black).build();
		fields[10] = new Street.Builder().setTitle("The Werewall").setDescription("Territory").setSubText("Price: 4300").setRent("1300")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[11] = new Street.Builder().setTitle("Mountain Village").setDescription("Territory").setSubText("Price: 4750")
				.setRent("1600").setBgColor(Color.white).setFgColor(Color.black).build();
		fields[12] = new Shipping.Builder().setTitle("The Buccaneers").setDescription("Fleet").setSubText("Price: 4000")
				.setBgColor(Color.blue).setFgColor(Color.white).build();
		fields[13] = new Street.Builder().setTitle("South Citidel").setDescription("Territory").setSubText("Price: 5000")
				.setRent("2000").setBgColor(Color.white).setFgColor(Color.black).build();
		fields[14] = new Street.Builder().setTitle("Monestary").setDescription("Refuge").setSubText("Reward: 500")
				.setBgColor(Color.green).setFgColor(Color.black).build();
		fields[15] = new Street.Builder().setTitle("The Pit").setDescription("Labor Camp").setSubText("Punishment: Eyes x 100")
				.setBgColor(Color.yellow).setFgColor(Color.black).build();
		fields[16] = new Street.Builder().setTitle("Palace Gates").setDescription("Territory").setSubText("Price: 5500").setRent("2600")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[17] = new Shipping.Builder().setTitle("Privateer armada").setDescription("Fleet").setSubText("Price: 4000")
				.setBgColor(Color.blue).setFgColor(Color.white).build();
		fields[18] = new Street.Builder().setTitle("Caravan").setDescription("Tax").setSubText("4000 or 10% of balance tax!").setBgColor(Color.red)
				.setFgColor(Color.black).build();
		fields[19] = new Street.Builder().setTitle("Tower").setDescription("Territory").setSubText("Price: 6000").setRent("3200")
				.setBgColor(Color.white).setFgColor(Color.black).build();
		fields[20] = new Street.Builder().setTitle("Castle").setDescription("Territory").setSubText("Price: 8000").setRent("4000")
				.setBgColor(Color.white).setFgColor(Color.black).build();
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

	public static int getUserRoll() {
		int value = 0;
		Cup thecup = new Cup();

		String input = GUI.getUserButtonPressed("You landed on a labor camp, to determine your punishment: ", "Roll");

		if (input.equals("Roll"))
			value = thecup.roll();

		return value;
	}

	// Player choice of buying a square or not.
	public static boolean getBuyChoice(Ownable field) {

		String input = GUI.getUserButtonPressed("Buy " + field.toString() + ":", "Yes", "No");
		if (input.equals("Yes"))
			return true;
		else
			return false;
	}

	// Player choice of paying 10% flatrate tax or Tax amount.
	
	public static String rateOrAmount(Tax theTax){
		
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
