package board;
import game.GUIControl;
import game.Player;
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
	 * @param id
	 * @param bonus
	 */
	public Refuge(String name, int id ,int bonus) {
		super(name, id);
		this.bonus=bonus;
	}
	@Override
	public void landOnSquare(Player player) {//adds the bonus amount of this instance to the players balance.
		player.deposit(bonus);
		GUIControl.refugeMessage(this,player,bonus);
		GUIControl.updateBalance(player);
	}
}
