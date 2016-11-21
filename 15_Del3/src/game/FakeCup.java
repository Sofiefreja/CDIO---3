package game;

public class FakeCup {
	private FakeDice d1;
	private FakeDice d2;
	
	/**
	 * Creates a cup with defined face values.
	 * @param value1
	 * @param value2
	 */
	public FakeCup (int value1, int value2){
		d1= new FakeDice(value1);
		d2= new FakeDice(value2);
	}
	public int roll(){
		return d1.getValue()+d2.getValue();
	}
	public int getSum(){
		return d1.getValue()+d2.getValue();
	}
	public boolean getEquals(){
		boolean res =false;
		if(d1.getValue()==d2.getValue()){
			res=true;
		}
		return res;
	}
	public int getD1(){
		return d1.getValue();
	}
	public int getD2(){
		return d2.getValue();
	}
}
