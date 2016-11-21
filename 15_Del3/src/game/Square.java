package game;

public abstract class Square {
	protected String name;
	public Square( String name){
		this.name=name;
	}
	public abstract void landOnSquare(Player player);
}
