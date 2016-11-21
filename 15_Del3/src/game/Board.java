package game;
import java.util.*;
public class Board {
	protected int[] Square;
		
	public int[] getSquare() {
		ArrayList<Square> squares = new ArrayList<Square>();
		Territory Tribeenchampment = new Territory("Tribe Encampment", 1000);
		squares.add(Tribeenchampment);
		Fleet Secondsail = new Fleet("Second Sail", 4000);
		squares.add(Secondsail);
		Territory Crater = new Territory("Crater", 1500);
		squares.add(Crater);
		Refuge WalledCity = new Refuge("Walled city", 5000);
		squares.add(WalledCity);
		LaborCamp HutsitM = new LaborCamp("Huts in the mountain", 2500);
		squares.addAll(HutsitM);
		Territory Mountain = new Territory("Mountain", 2000);
		squares.add(Mountain);
		Fleet SeaGrover = new Fleet("Sea Grover", 4000);
		squares.add(SeaGrover);
		Territory ColdDesert = new Territory("Cold Desert", 3000);
		squares.add(ColdDesert);
		Territory BlackCave = new Territory("Black Cave", 4000);
		squares.add(BlackCave);
		Tax Goldmine = new Tax("Goldmine", -2000);
		squares.add(Goldmine);
		Territory Werewall = new Territory("Werewall", 4300);
		squares.add(Werewall);
		Territory MountainVillage = new Territory("Mountain Village", 4750);
		squares.add(MountainVillage);
		Fleet Buccaneers = new Fleet("Buccaneers", 4000);
		squares.add(Buccaneers);
		Territory SouthCitadel = new Territory("South Citadel", 5000);
		squares.add(SouthCitadel);
		Refuge Monastery = new Refuge("Monastery", 500);
		squares.add(Monastery);
		LaborCamp Pit = new LaborCamp("The pit", 2500);
		squares.addAll(Pit);
		Territory PalaceGates = new Territory("Palace Gates", 5500);
		squares.add(PalaceGates);
		Fleet PrivateerArmada = new Fleet("Privateer armada", 4000);
		squares.add(PrivateerArmada);
		Tax Caravan = new Tax("Caravan", -4000);
		squares.add(Caravan);
		Territory Tower = new Territory("Tower", 6000);
		squares.add(Tower);
		Territory Castle = new Territory("Castle", 8000);
		squares.add(Castle);
	return Square;
	}
}
