package board;
import game.Player;
import game.GUIControl;
/**
 * Class LaborCamp extended from Ownable.
 * @author Mathias Tværmose Gleerup
 *
 */
public class LaborCamp extends Ownable{
	//baseRent is the factor used in getRent().
	protected int baseRent=100; 
	
	/**
	 * Constructor for LaborCamp, which accepts two parameters, name and price.
	 * @param name
	 * @param id
	 * @param price
	 */
	public LaborCamp(String name, int id ,int price) {
		super(name,id,price);
	}

	@Override
	public int getRent() {//Overrides the getRent() method from Ownable.
		int rent=0;
		if(owner!=null){//if the instance is owned, the rent is calculated.
			rent=GUIControl.getUserRoll(this)*baseRent*owner.ownedTypes(this);//Gets a roll value from the player.
		}
		return rent;
	}
	
	@Override
	public void landOnSquare(Player player){//implements the method from Ownable.
		super.landOnSquare(player);
	}
	@Override
	public void clearOwner(){
		owner=null;
	}
}
