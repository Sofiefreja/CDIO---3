package game;
import java.util.ArrayList;
import desktop_resources.GUI;
import board.*;

public class Game {
	public Game(){
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
		String[] playerNames = GUIGame.numberOfPlayers();
		/*
		 * Creating the players. By using an array, the names are saved in each of 
		 * their own index'es in the array.
		 */
		ArrayList<Player> thePlayers = new ArrayList<Player>();
		for(int i = 0; i < playerNames.length; i++){
			thePlayers.add(new Player(playerNames[i]));
		}
		/*
		 * Beginning the game. 
		 */
		String turn = GUIGame.getUserInputTurn(thePlayers.get(0));
		if(turn.equals("roll")){
			theCup.roll();
			GUIGame.showDice(theCup);
			thePlayers.get(0).moveCar(theCup.getSum());
			GUIGame.moveVehicle(thePlayers.get(0));
			int newPosition = thePlayers.get(0).getCurrentPosition();
			Square currentSquare = theBoard.getSquare(newPosition);
			currentSquare.landOnSquare(thePlayers.get(0));
		} else if(turn.equals("Surrender")){
			
		}
	}
}
