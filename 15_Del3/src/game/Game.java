package game;

import java.util.ArrayList;
import desktop_resources.GUI;
import board.*;

public class Game {
	public Game() {
		/*
		 * Initializing the game.
		 */
		GUIControl GUIGame = new GUIControl();
		GUIGame.makeBoard();
		Board theBoard = new Board();
		Cup theCup = new Cup();
		/*
		 * The players are initialized
		 */
		String[] playerNames = GUIGame.numberOfPlayers(); // Ask how many
															// players there are
															// in the game.
		/*
		 * Creating the players. By using an array, the names are saved in each
		 * of their own index'es in the array.
		 */
		ArrayList<Player> thePlayers = new ArrayList<Player>(); // Save all the
																// players in a
																// ArrayList.

		for (int i = 0; i < playerNames.length; i++) {

			thePlayers.add(new Player(playerNames[i])); // Creating Player
														// objects.
			GUIGame.createPlayer(new Player(playerNames[i])); // Creating Player
																// for the GUI.
		}

		/*
		 * en while loop. Beginning the game.
		 */
		boolean firstTurn = true;
		int firstRound = 0;
		int numberOfPlayers = playerNames.length;
		

		while (thePlayers.size()>1){ // The game should run until one
						// player remains in the ArrayList.
			
			for (int i = 0; i < thePlayers.size(); i++) { // The for loop
															// running
															// through all the
															// players.

				String turn = GUIGame.getUserInputTurn(thePlayers.get(i)); // Ask
				// what the player what to do.

				if (turn.equals("Roll")) {
					theCup.roll();
					GUIGame.showDice(theCup);
					// Move the Vehicle on board.
					if (firstTurn == true) {
						System.out.println("Første runde: " +firstTurn);
						thePlayers.get(i).setPosition(theCup.getSum());
						GUIGame.moveVehicleFirstTime(thePlayers.get(i));
						firstRound++;
						if(firstRound==numberOfPlayers){
							firstTurn=false;
							System.out.println("Første runde er overstået");
						}
					} else {
						thePlayers.get(i).moveCar(theCup.getSum());
						GUIGame.moveVehicle(thePlayers.get(i));
					}
					// Call the landOnSquare(Player --- )
					int newPosition = thePlayers.get(i).getCurrentPosition();
					theBoard.getSquare(newPosition).landOnSquare(thePlayers.get(i));
					if(thePlayers.get(i).getBalance()<0){
						GUIGame.removePlayer(thePlayers.get(i));
						thePlayers.remove(i);
						thePlayers.trimToSize();
					}
				} else if (turn.equals("Surrender")) {
					GUIGame.removePlayer(thePlayers.get(i));
					thePlayers.remove(i);
					thePlayers.trimToSize();
				}
			}
		}
		GUIGame.showWinner(thePlayers.get(0));
	}
}

// thePlayers.toString();
