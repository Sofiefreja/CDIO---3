package game;

import java.util.*;

public class Fleet extends Ownable {

	private int RENT_1 = 500;
	private int RENT_2 = 1000;
	private int RENT_3 = 2000;
	private int RENT_4 = 4000;

	public Fleet(String name, int price) {
		super(name, price);
	}

	public int getRent() {
		if (owner != null) {
			switch (owner.owned(this)) {
			case 1:
				return RENT_1;
				break;
			case 2:
				return RENT_2;
				break;
			case 3:
				return RENT_3;
				break;
			case 4:
				return RENT_4;
				break;
			}
		}

	}

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
