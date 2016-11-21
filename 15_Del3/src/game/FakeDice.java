package game;

public class FakeDice extends Dice{
	
	public FakeDice(int value){
		this.value=value;
	}
	public int roll(){
		return value;
	}
	public int getValue(){
		return value;
	}
}

