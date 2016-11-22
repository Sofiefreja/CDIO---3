package game;
/**
 * Abstract class, extended from Square, which is super class to all ownable squares.
 * @author Mathias Tværmose Gleerup
 *
 */
public abstract class Ownable extends Square {
	/**
	 * Adds a field Player and int for all ownable squares.
	 */
	protected Player owner;
	protected int price;
	/**
	 * Constructor which takes a name and a price of the square as parameters.
	 * @param name
	 * @param price
	 */
	public Ownable(String name, int price){
		super(name);
		this.price=price;
	}
	/**
	 * Method for getting the rent of this instance.
	 * @return rent.
	 */
	public abstract int getRent();
	
	
	@Override
	public void landOnSquare(Player player) {//Implements the inherited method landOnSquare, to be overridden for each type with a different getRent() method.
		if (owner != null) {
			player.pay(getRent());
			owner.deposit(getRent());
		} else {
			if (GUIControl.MethodForAskingUserIfHeWantsToBuyTheSquare() == true) {
				player.bought(this);
				player.pay(price);
				owner = player;
			}
		}
	}
}
