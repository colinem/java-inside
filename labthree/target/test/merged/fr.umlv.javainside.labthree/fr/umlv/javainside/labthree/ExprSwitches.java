package fr.umlv.javainside.labthree;

public class ExprSwitches {
    
    enum enumeration {
        DEBUG, ERROR, WARNING, INFO;
    }
	
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

    public static String enumSwitch(enumeration i) {
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
    
    
    // NOUVELLE VERSION //
	
	public static String exprIntSwitch(int val) {
		return switch (val) {
		case 0 -> {break "zero";}
		case 1 -> {break "one";}
		case 2 -> {break "a lot";}
		default -> throw new IllegalArgumentException();
		};
	}
    // Fonctionnement de la machine identique poour les deux methodes 
    // exprIntSwitch et intSwitch
	
	public static String exprIntSwitch2(int val) {
		return switch (val) {
		case 10 -> "ten";
		case 0, 3 -> "zero"; // virgule pour resolution du fallthrough
		case 100 -> "a lot";
		default -> throw new IllegalArgumentException(); // cas default
		};
	}
    // Fonctionnement de la machine identique poour les deux methodes 
    // exprIntSwitch2 et intSwitch2
    
    public static String exprStringSwitch(String i) {
        return switch(i) {
        case "foo", "viva zorg" -> "zero";
        case "bar" -> "one";
        case "baz" -> "a lot";
		default -> throw new IllegalArgumentException();
        };
    }

    public static String exprEnumSwitch(enumeration i) {
        return switch(i) {
        case DEBUG, ERROR -> "zero";
        case WARNING -> "one";
        case INFO -> "a lot";
		default -> throw new IllegalArgumentException();
        };
    }

}
