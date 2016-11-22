package board;

import game.Player;

/**
 * Class Fleet extended from Ownable.
 * @author Mathias Tværmose Gleerup
 *
 */
public class Fleet extends Ownable {
	/*
	 * integers RENT_#
	 */
	private final int RENT_1 = 500;
	private final int RENT_2 = 1000;
	private final int RENT_3 = 2000;
	private final int RENT_4 = 4000;
	
	/**
	 * Constructor which takes name and price as parameters.
	 * @param name
	 * @param id
	 * @param price
	 */
	public Fleet(String name, int id , int price) {
		super(name, id , price);
	}
	@Override
	public int getRent() {//Implements the inherited getRent() for Fleet
		if (owner != null) { //If the owner field is not empty for the current instance, following statement is initiated.
			switch (owner.ownedTypes(this)) { //uses a method on the Player owner, to return how many instances of this type the owner owns.
			case 1:
				return RENT_1;
			case 2:
				return RENT_2;
			case 3:
				return RENT_3;
			case 4:
				return RENT_4;
			}
		}
		//returns 0 if the instance isn't owned. This is only here because the method always must return an integer.
		//This method will only be used if the instance is owned
		return 0;  
	}
	@Override
	public void landOnSquare(Player player) {//Implements the inherited landOnSquare for the class Fleet
		super.landOnSquare(player);
	}
}
