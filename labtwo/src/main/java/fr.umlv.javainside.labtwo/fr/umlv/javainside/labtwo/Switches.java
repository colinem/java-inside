package fr.umlv.javainside.labtwo;

public class Switches {
	
	public static String intSwitch(int val) {
		switch (val) {
		case 0:
			return "zero";
		case 1:
			return "one";
		case 2:
			return "a lot";
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public static String intSwitch2(int val) {
		switch (val) {
		case 10:
			return "ten";
		case 0:
			return "zero";
		case 100:
			return "a lot";
		default:
			throw new IllegalArgumentException();
		}
	}
	
	/*
	 * Si les valeurs se suivent : tableswitch
	 * si elles ne se suivent pas : lookepswitch (sinon il serait obligé de générer toutes les valeurs intermédiaires) -> il remet les valeurs dans le bon ordre pour pouvoir faire la recherche de la valeur voulue.
	 */

}
