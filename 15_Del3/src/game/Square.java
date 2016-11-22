package game;

public abstract class Square {
	/**
	 * Abstract class, super for all types of Squares.
	 */
	protected String name;
	
	/**
	 * Super constructor which takes a String name as a parameter.
	 * @param name
	 */
	public Square( String name){
		this.name=name;
	}
	/**
	 * Method which determines what happens to a player when he lands on this instance.
	 * @param player
	 */
	public abstract void landOnSquare(Player player);
}
