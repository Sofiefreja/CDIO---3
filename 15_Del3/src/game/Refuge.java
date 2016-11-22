package game;
/**
 * Class Refuge exteded from Square.
 * @author Mathias Tværmose Gleerup
 *
 */
public class Refuge extends Square{
	private int bonus;
	/**
	 * Constructor which accepts two parameters name and bonus.
	 * @param name
	 * @param bonus
	 */
	public Refuge(String name, int bonus) {
		super(name);
		this.bonus=bonus;
	}
	@Override
	public void landOnSquare(Player player) {//adds the bonus amount of this instance to the players balance.
		player.deposit(bonus);
	}
}
