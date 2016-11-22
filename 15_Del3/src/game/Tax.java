package game;

public class Tax extends Square{
	int taxAmount; //amount defined in constructor
	int taxRate=10; //rate 
	/**
	 * Constructor which accepts two parameters name and taxAmount for this specific instance.
	 * @param name
	 * @param taxAmount
	 */
	public Tax(String name, int taxAmount) {
		super(name);
		this.taxAmount=taxAmount;
	}
	/**
	 * method for getting taxAmount.
	 * @return taxAmount
	 */
	public int getTaxAmount(){
		return taxAmount;
	}
	
	@Override
	public void landOnSquare(Player player) {
		String ask;
		ask=GUIControl.rateOrAmount(this);
		if(ask.equals("Rate")){//if the player chose to pay the 10 % tax rate, this is calculated and payed.
			player.pay((player.getBalance()/taxRate));
		}else{ //else the taxAmount for this instance is payed.
			player.pay(taxAmount);
		}
	}
}
