package fr.umlv.javainside.labfour;

import java.util.Iterator;
import java.util.NoSuchElementException;

import fr.umlv.javainside.labfour.Exemple1.Scheduler;

public class Generators<T> {
	
	private Iterator<T> generateIterator(Scheduler s, Inter i) {
		
		return new Iterator<>() {
			
			@Override
			public boolean hasNext() {
				return false;
			}
			
			@Override
			public T next() {
				if (!hasNext())
					throw new NoSuchElementException();
				return null;
			}
		};
	}
	
	@FunctionalInterface
	interface Inter {
		void funct(Yielder y);
	}
	
}
