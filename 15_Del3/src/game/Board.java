package game;
import board.*;
public class Board {
	/* Class, to initialize the board and the square. 
	 * Author: Sofie Freja Christensen
	 */
	Square[] squares = new Square[21];
	public Board(){
	/*
	 * An array of the type square. In these indexes, It's defined which type
	 * of square it is, and prices and rents of the different squares.  
	 */
	squares[0] = new Territory("Tribe Encampment", 0, 1000, 100);
	squares[1] = new Fleet("Second Sail", 1, 4000);
	squares[2] = new Territory("Crater", 2,  1500, 300);
	squares[3] = new Refuge("Walled city", 3, 5000);
	squares[4] = new LaborCamp("Huts in the mountain", 4, 2500);
	squares[5] = new Territory("Mountain", 5, 2000, 500);
	squares[6] = new Fleet("Sea Grover", 6, 4000);
	squares[7] = new Territory("Cold Desert", 7, 3000, 700);
	squares[8] = new Territory("Black Cave", 8, 4000, 1000);
	squares[9] = new Tax("Goldmine", 9, 2000);
	squares[10] = new Territory("Werewall", 10, 4300, 1300);
	squares[11] = new Territory("Mountain Village", 11, 4750, 1600);
	squares[12] = new Fleet("Buccaneers", 12, 4000);
	squares[13] = new Territory("South Citadel", 13, 5000, 2000);
	squares[14] = new Refuge("Monastery", 14, 500);
	squares[15] = new LaborCamp("The pit", 15, 2500);
	squares[16] = new Territory("Palace Gates", 16, 5500, 2600);
	squares[17] = new Fleet("Privateer armada", 17, 4000);
	squares[18] = new Tax("Caravan", 18, 4000);
	squares[19] = new Territory("Tower", 19, 6000, 3200);
	squares[20] = new Territory("Castle", 20, 8000, 4000);
	}
	/*
	 * Method to retrieve information, from one specific square.
	 */
	public Square getSquare(int ren) {
		return squares[ren];
	}
}
