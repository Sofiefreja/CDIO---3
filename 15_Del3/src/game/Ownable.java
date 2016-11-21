package game;

public abstract class Ownable extends Square {
	protected Player owner;
	protected int price;
	
	public Ownable(String name, int price){
		super(name);
		this.price=price;
	}
	public abstract int getRent();
}
