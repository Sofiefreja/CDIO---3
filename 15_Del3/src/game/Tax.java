package game;

public class Tax extends Square{
	int taxAmount;
	int taxRate=10;
	public Tax(String name, int taxAmount) {
		super(name);
		this.taxAmount=taxAmount;
	}
	public int getTaxAmount(){
		return taxAmount;
	}
	@Override
	public void landOnSquare(Player player) {
		String ask;
		ask=GUIControl.rateOrAmount(this);
		if(ask.equals("Rate")){
			player.pay((player.getBalance()/10));
		}else{
			player.pay(taxAmount);
		}
	}
}
