package fr.umlv.javainside.labfour;

public class Exemple1 {

	public static void main() {
		
		var s = new ContinuationScope("hello1");
		Continuation c = new Continuation(s, 
				() -> {
					Continuation.yield(s);
					System.out.println("hello continuation");
				});
		c.run();
		System.out.println("test");
		c.run();

	}

}
