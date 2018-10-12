package fr.umlv.javainside.labthreeb;

import java.util.function.ToIntFunction;

public class HelloConciseMethod {

	int length(String s) {
	    return s.length();
	}
	
	int expressionLength(String s) -> s.length();

	public static void main(String args[]) {
		
		System.out.println("longueur : " + new HelloConciseMethod().expressionLength);
		
	}

}