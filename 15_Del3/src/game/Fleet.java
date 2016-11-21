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
			case 2:
				return RENT_2;
			case 3:
				return RENT_3;
			case 4:
				return RENT_4;
			}
		}
		return 0;
		
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
