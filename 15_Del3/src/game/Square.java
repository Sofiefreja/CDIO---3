package game;
/**
 * Abstract class Square, superclass to all Squares.
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
	 * Returns the name of the Square
	 * @return name
	 */
	public String toString(){
		return name;
	}
	/**
	 * Method which determines what happens to a player when he lands on this instance.
	 * @param player
	 */
	public abstract void landOnSquare(Player player);
}
