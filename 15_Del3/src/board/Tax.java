package board;

import game.Player;
import game.GUIControl;

/**
 * Class Tax extended from Square.
 * 
 * @author Mathias Tværmose Gleerup
 *
 */
public class Tax extends Square {
	private int taxAmount; // amount defined in constructor
	private int taxRate = 10; // rate

	/**
	 * Constructor which accepts two parameters name and taxAmount for this
	 * specific instance.
	 * 
	 * @param name
	 * @param id
	 * @param taxAmount
	 */
	public Tax(String name, int id, int taxAmount) {
		super(name, id);
		this.taxAmount = taxAmount;
	}

	/**
	 * method for getting taxAmount.
	 * 
	 * @return taxAmount
	 */
	public int getTaxAmount() {
		return taxAmount;
	}

	@Override
	public void landOnSquare(Player player) {
		if (player.getBalance() > taxAmount) {
			String ask;
			ask = GUIControl.rateOrAmount(this, player);// Asks the player
														// whether he wants to
														// pay the 10 percent
														// tax rate or the set
														// tax amount.
			if (ask.equals("Tax rate")) {// if the player chose to pay the 10 %
											// tax rate, this is calculated and
											// payed.
				int pay = player.getBalance() / taxRate;
				player.pay(pay);
				GUIControl.taxMessage(player, pay);
			} else if (ask.equals("Tax Amount")) { // else the taxAmount for
													// this instance is payed.
				player.pay(taxAmount);
				GUIControl.taxMessage(player, taxAmount);
				GUIControl.updateBalance(player);
			}
		} else {//if the player has a lower balance than the taxAmount, he is automatically charged 10% tax rate.
			GUIControl.taxNotEnoughMoney(this);//message is printed.
			int pay = player.getBalance()/taxRate;
			player.pay(pay);
			GUIControl.updateBalance(player);
		}
	}
}
