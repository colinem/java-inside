package fr.umlv.javainside.labone;

import java.util.stream.IntStream;


public class Sums {
	public static int loopSum(int n) {
		int sum = 0;
		for (int i = 1 ; i <= n ; i++)
			sum += i;
		return sum;
	}
	
	public static int streamSum(int n) {
		return IntStream.range(1, n+1).sum();
	}

}
