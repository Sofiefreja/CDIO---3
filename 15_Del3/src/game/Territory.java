package game;

public class Territory extends Ownable {
	int rent;

	public Territory(String name, int price, int rent) {
		super(name, price);
		this.rent = rent;
	}

	@Override
	public int getRent() {
		return rent;
	}

	@Override
	public void landOnSquare(Player player) {
		if (owner != null) {
			player.pay(getRent());
			owner.deposit(getRent());
		} else {
			if (GUIControl.MethodForAskingUserIfHeWantsToBuyTheSquare() == true) {
				player.bought(this);
				player.pay(price);
				owner = player;
			}
		}
	}

}
