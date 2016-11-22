package game;
import java.util.*;
import board.*;
public class Board {
	protected int[] Square;
		
	public ArrayList<Square> getSquare(int rent, int price) {
		ArrayList<Square> squares = new ArrayList<Square>();
		Territory Tribeenchampment = new Territory("Tribe Encampment", price = 1000, rent = 100);
		squares.add(Tribeenchampment);
		Fleet Secondsail = new Fleet("Second Sail", price = 4000);
		squares.add(Secondsail);
		Territory Crater = new Territory("Crater", price = 1500, rent = 300);
		squares.add(Crater);
		Refuge WalledCity = new Refuge("Walled city", 5000);
		squares.add(WalledCity);
		LaborCamp HutsitM = new LaborCamp("Huts in the mountain", 2500);
		squares.add(HutsitM);
		Territory Mountain = new Territory("Mountain", price = 2000, rent = 500);
		squares.add(Mountain);
		Fleet SeaGrover = new Fleet("Sea Grover", price = 4000);
		squares.add(SeaGrover);
		Territory ColdDesert = new Territory("Cold Desert", price = 3000, rent = 700);
		squares.add(ColdDesert);
		Territory BlackCave = new Territory("Black Cave", price = 4000, rent = 1000);
		squares.add(BlackCave);
		Tax Goldmine = new Tax("Goldmine", -2000);
		squares.add(Goldmine);
		Territory Werewall = new Territory("Werewall", price = 4300, rent = 1300);
		squares.add(Werewall);
		Territory MountainVillage = new Territory("Mountain Village", price = 4750, rent = 1600);
		squares.add(MountainVillage);
		Fleet Buccaneers = new Fleet("Buccaneers", price = 4000);
		squares.add(Buccaneers);
		Territory SouthCitadel = new Territory("South Citadel", price = 5000, rent = 2000);
		squares.add(SouthCitadel);
		Refuge Monastery = new Refuge("Monastery", 500);
		squares.add(Monastery);
		LaborCamp Pit = new LaborCamp("The pit", 2500);
		squares.add(Pit);
		Territory PalaceGates = new Territory("Palace Gates", price = 5500, rent = 2600);
		squares.add(PalaceGates);
		Fleet PrivateerArmada = new Fleet("Privateer armada", price = 4000);
		squares.add(PrivateerArmada);
		Tax Caravan = new Tax("Caravan", -4000);
		squares.add(Caravan);
		Territory Tower = new Territory("Tower", price = 6000, rent = 3200);
		squares.add(Tower);
		Territory Castle = new Territory("Castle", price = 8000, rent = 4000);
		squares.add(Castle);
	return squares;
	}
}
