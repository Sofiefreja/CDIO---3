package test;


import game.Player;
import board.LaborCamp;

public class FakeLaborCamp extends LaborCamp {
	private FakeCup cup;
	public FakeLaborCamp(String name, int id, int price, int d1, int d2) {
		super(name, id, price);
		cup = new FakeCup(d1,d2);
	}

	@Override
	public int getRent() {// Overrides the getRent() method from Ownable.
		int rent = 0;
		if (owner != null) {// if the instance is owned, the rent is calculated.
			rent = cup.roll() * baseRent * owner.ownedTypes(this);// Gets a roll
		}
		return rent;
	}

	@Override
	public void landOnSquare(Player player) {// implements the method from
												// Ownable.
		super.landOnSquare(player);
	}
}
