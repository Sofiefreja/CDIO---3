package game;

public class Territory extends Ownable {
	int rent;
	/**
	 * Constructor for Territory which accepts name, price and rent when owned for this instance.
	 * @param name
	 * @param price
	 * @param rent
	 */
	public Territory(String name, int price, int rent) {
		super(name, price);
		this.rent = rent;
	}

	@Override
	public int getRent() {//Implements the inherited getRent() for Territory.
		return rent;
	}

	@Override
	public void landOnSquare(Player player) {//Implements the inherited landOnSquare() for Territory.
		super.landOnSquare(player);
//		if (owner != null) {
//			player.pay(getRent());
//			owner.deposit(getRent());
//		} else {
//			if (GUIControl.MethodForAskingUserIfHeWantsToBuyTheSquare() == true) {
//				player.bought(this);
//				player.pay(price);
//				owner = player;
//			}
//		}
	}

}
