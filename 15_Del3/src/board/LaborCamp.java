package board;
import game.Player;
/**
 * Class LaborCamp extended from Ownable.
 * @author Mathias Tværmose Gleerup
 *
 */
public class LaborCamp extends Ownable{
	//baseRent is the factor used in getRent().
	private int baseRent=100; 
	
	/**
	 * Constructor for LaborCamp, which accepts two parameters, name and price.
	 * @param name
	 * @param price
	 */
	public LaborCamp(String name, int id ,int price) {
		super(name,id,price);
	}

	@Override
	public int getRent() {//Overrides the getRent() method from Ownable.
		int rent=0;
		if(owner!=null){//if the instance is owned, the rent is calculated.
			rent=GUIControl.getUserRoll()*baseRent*owner.owned(this);
		}
		return rent;
	}
	
	@Override
	public void landOnSquare(Player player){
		super.landOnSquare(player);
	}
}
