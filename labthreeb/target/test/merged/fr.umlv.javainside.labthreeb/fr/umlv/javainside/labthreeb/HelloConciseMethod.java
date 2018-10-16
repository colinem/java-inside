package fr.umlv.javainside.labthreeb;

import java.util.function.ToIntFunction;

public class HelloConciseMethod {
	
	ToIntFunction<String> statementLenFn = (String s) -> { return s.length(); };
	
	ToIntFunction<String> expressionLenFn = (String s) -> s.length();

	public static void main(String args[]) {
		
		System.out.println("longueur : " + new HelloConciseMethod().statementLenFn);
		
	}

}