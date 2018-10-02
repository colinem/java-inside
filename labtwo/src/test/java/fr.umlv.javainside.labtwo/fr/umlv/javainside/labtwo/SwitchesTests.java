package fr.umlv.javainside.labtwo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SwitchesTests {

	@Test
	void testIntSwitch() {
		assertThrows(IllegalArgumentException.class, () -> Switches.intSwitch(-1));
		assertEquals("zero", Switches.intSwitch(0));
		assertEquals("one", Switches.intSwitch(1));
		assertEquals("a lot", Switches.intSwitch(2));
	}

}
