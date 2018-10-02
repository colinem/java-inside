package fr.umlv.javainside.labtwo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.IntFunction;

import org.junit.jupiter.params.ParameterizedTest;

class SwitchesTests {

	@ParameterizedTest
	@MethodSource
	void testIntSwitch(Stream<>) {
		assertThrows(IllegalArgumentException.class, () -> Switches.intSwitch(-1));
		assertEquals("zero", Switches.intSwitch(0));
		assertEquals("one", Switches.intSwitch(1));
		assertEquals("a lot", Switches.intSwitch(2));
	}

}
