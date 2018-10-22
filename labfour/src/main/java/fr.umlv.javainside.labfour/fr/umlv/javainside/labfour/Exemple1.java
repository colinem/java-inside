package fr.umlv.javainside.labfour;

import java.util.ArrayDeque;
import java.util.concurrent.ThreadLocalRandom;

import com.sun.jndi.toolkit.ctx.Continuation;

public class Exemple1 {
	
	private enum ExecutionOrder {
		STACK, FIFO, RANDOM;
	}

	public static void main() {

		var scheduler = new Scheduler(ExecutionOrder.RANDOM);
		var s = new ContinuationScope("hello1");
		
		Runnable r = () -> {
			System.out.println("hello continuation");
			//Continuation.yield(s); // IllegalSateException : peux pas sortir du synchronized avec un yield sinon tu sors avec ton token c'est pas bon
			scheduler.enqueue(s);
			System.out.println(Continuation.getCurrentContinuation(s));
		};
		
		for (int i = 0 ; i < 2 ; i++)
			new Continuation(s, r).run();
		
		scheduler.runLoop();

	}
	
	
	static class Scheduler {
		
		private final ArrayDeque<Continuation> continuations = new ArrayDeque<>();
		private final ExecutionOrder executionOrder;
		
		
		public Scheduler(ExecutionOrder eo) {
			executionOrder = eo;
		}
		
		public void enqueue(ContinuationScope s) {
			var c = Continuation.getCurrentContinuation(s);
			if (c == null)
				throw new IllegalStateException("No current continuation");
			continuations.addLast(c);
			Continuation.yield(s);
		}
		
		public void runLoop() {
			
			switch (executionOrder) {
			case STACK:
				while(!continuations.isEmpty())
					continuations.removeLast().run();
				break;
			case FIFO:
				while(!continuations.isEmpty())
					continuations.removeFirst().run();
				break;
			case RANDOM:
				while(!continuations.isEmpty()) {
					Continuation[] tmp = continuations.toArray(new Continuation[continuations.size()]);
					Continuation c = tmp[ThreadLocalRandom.current().nextInt(continuations.size())];
					continuations.remove(c);
					c.run();
				}
				break;
			}			
		}
		
	}
	

}
