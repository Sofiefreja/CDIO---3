package test;

import game.Cup;

/**
 * Class FakeCup exteded from Cup.
 * Uses two FakeDice.
 * Is used for testing the methods of Cup.
 * @author Mathias Tværmose Gleerup
 *
 */
public class FakeCup extends Cup {
	private FakeDice d1;
	private FakeDice d2;
	
	/**
	 * Creates a FakeCup with defined face values.
	 * @param value1
	 * @param value2
	 */	
	public FakeCup (int value1, int value2){
		d1= new FakeDice(value1);
		d2= new FakeDice(value2);
	}
	@Override
	public int roll(){
		return d1.getValue()+d2.getValue();
	}
	@Override
	public int getSum(){
		return d1.getValue()+d2.getValue();
	}
	@Override
	public boolean getEquals(){
		boolean res =false;
		if(d1.getValue()==d2.getValue()){
			res=true;
		}
		return res;
	}
	@Override
	public int getD1(){
		return d1.getValue();
	}
	@Override
	public int getD2(){
		return d2.getValue();
	}
}
