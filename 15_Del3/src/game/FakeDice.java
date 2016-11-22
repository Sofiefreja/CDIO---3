package game;
/**
 * Class FakeDice extended from Dice.
 * Is used to test the methods of Dice.
 * @author Mathias Tværmose Gleerup
 *
 */
public class FakeDice extends Dice{
	/**
	 * Constructor for FakeDice.
	 * @param value
	 */
	public FakeDice(int value){
		this.value=value;
	}
	@Override
	public int roll(){
		return value;
	}
	@Override
	public int getValue(){
		return value;
	}
}

