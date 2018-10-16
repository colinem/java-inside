package fr.umlv.javainside.labfour;

public class Exemple1 {	

	public static void main() {
		
		Object lock = new Object();
		var s = new ContinuationScope("hello1");
		Continuation c = new Continuation(s, 
				() -> {
					synchronized(lock) { // IllegalSateException : peux pas sortir du synchronized avec un yield sinon tu sors avec ton token c'est pas bon
						Continuation.yield(s);
					}
					System.out.println("hello continuation");
					System.out.println(Continuation.getCurrentContinuation(s));
				});
		c.run();
		c.run();
		System.out.println(Continuation.getCurrentContinuation(s));
		System.out.println(Thread.currentThread());

	}

}
