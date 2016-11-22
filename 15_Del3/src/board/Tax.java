package board;
import game.Player;
import game.GUIControl;
/**
 * Class Tax extended from Square.
 * @author Mathias Tværmose Gleerup
 *
 */
public class Tax extends Square{
	private int taxAmount; //amount defined in constructor
	private int taxRate=10; //rate 
	/**
	 * Constructor which accepts two parameters name and taxAmount for this specific instance.
	 * @param name
	 * @param id
	 * @param taxAmount
	 */
	public Tax(String name,int id, int taxAmount) {
		super(name,id);
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
		ask=GUIControl.rateOrAmount(this);//Asks the player whether he wants to pay the 10 percent tax rate or the set tax amount.
		if(ask.equals("Tax rate")){//if the player chose to pay the 10 % tax rate, this is calculated and payed.
			player.pay((player.getBalance()/taxRate));
		}else if(ask.equals("Tax Amount")){ //else the taxAmount for this instance is payed.
			player.pay(taxAmount);
		}
	}
}
