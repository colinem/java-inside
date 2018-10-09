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
    
    public static String stringSwitch(String i) {
        switch(i) {
        case "foo" : case "viva zorg" :
            return "zero" ;
        case "bar" :
            return "one" ;
        case "baz" :
            return "a lot" ;
        }

        throw new IllegalArgumentException() ;
    }

    public static String enumSwitch(int i) {
        switch(i) {
        case DEBUG : case ERROR :
            return "zero" ;
        case WARNING :
            return "one" ;
        case INFO :
            return "a lot" ;
        }

        throw new IllegalArgumentException() ;
    }

}
