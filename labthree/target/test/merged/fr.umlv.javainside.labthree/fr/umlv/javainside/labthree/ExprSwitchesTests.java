package fr.umlv.javainside.labthree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.function.IntFunction;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import fr.umlv.javainside.labthree.ExprSwitches.enumeration;



class ExprSwitchesTests {
	static class TestData {
		IntFunction function;
		int parameter;
		String expectedReturn;
		
		public TestData(IntFunction function,int parameter, String expectedReturn) {
			this.function = function;
			this.parameter = parameter;
			this.expectedReturn = expectedReturn;
		}
		public IntFunction getFunction() {
			return function;
		}
		public int getParameter() {
			return parameter;
		}
		public String getExpectedReturn() {
			return expectedReturn;
		}
	}
	
	@ParameterizedTest
	@MethodSource("testDataProvider")
	void intSwitchtest(TestData function) {
		assertEquals(function.expectedReturn, function.getFunction().apply(function.getParameter()));
	}
	@ParameterizedTest
	@MethodSource("getIntFunction")
	void intSwitchtestError(IntFunction<String> function) {
		assertThrows(IllegalArgumentException.class, () -> function.apply(-1));
	}
	
	@Test
	void StringSwitchtest() {
		assertEquals("zero", ExprSwitches.exprStringSwitch("foo"));
		assertEquals("one", ExprSwitches.exprStringSwitch("bar"));
		assertEquals("a lot", ExprSwitches.exprStringSwitch("baz"));
		assertEquals("zero", ExprSwitches.exprStringSwitch("viva zorg"));
	}
	@Test
	void StringSwitchtestError() {
		assertThrows(IllegalArgumentException.class, () -> ExprSwitches.exprStringSwitch("Toto"));
	}
	@Test
	void EnumSwitchtest() {
		assertEquals("zero", ExprSwitches.exprEnumSwitch(enumeration.DEBUG));
		assertEquals("one", ExprSwitches.exprEnumSwitch(enumeration.WARNING));
		assertEquals("a lot", ExprSwitches.exprEnumSwitch(enumeration.INFO));
		assertEquals("zero", ExprSwitches.exprEnumSwitch(enumeration.ERROR));
	}
	static Stream<TestData> testDataProvider() {
	    List<TestData> lst = List.of(new TestData(ExprSwitches::exprIntSwitch, 0, "zero"), new TestData(ExprSwitches::exprIntSwitch, 3, "zero"), new TestData(ExprSwitches::exprIntSwitch2, 3, "zero"),new TestData(ExprSwitches::exprIntSwitch, 1, "one"), new TestData(ExprSwitches::exprIntSwitch, 2, "a lot"), new TestData(ExprSwitches::exprIntSwitch2, 0, "zero"), new TestData(ExprSwitches::exprIntSwitch2, 10, "one"), new TestData(ExprSwitches::exprIntSwitch2, 100, "a lot"));
	    return lst.stream();
	}
	static Stream<IntFunction> getIntFunction() {
		List<IntFunction> lst = List.of(ExprSwitches::exprIntSwitch, ExprSwitches::exprIntSwitch2);
		return lst.stream();
	}
}
