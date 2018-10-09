package fr.umlv.javainside.labthree;

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

}
