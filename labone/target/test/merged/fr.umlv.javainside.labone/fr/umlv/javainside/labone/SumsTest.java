package fr.umlv.javainside.labone;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SumsTest {

	@Test
	void testLoopSum() {
		assertEquals(10, Sums.loopSum(4));
		assertEquals(28, Sums.loopSum(7));
	}

	@Test
	void testStreamSum() {
		assertEquals(10, Sums.streamSum(4));
		assertEquals(28, Sums.streamSum(7));
	}

}
