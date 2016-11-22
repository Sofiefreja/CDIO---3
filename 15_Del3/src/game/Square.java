package game;
/**
 * Abstract class Square, superclass for all Squares.
 * @author Mathias Tværmose Gleerup
 *
 */
public abstract class Square {
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
