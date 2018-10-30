package labsix;

import static org.junit.Assert.assertEquals;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

class ExampleTests {

	@Test
	void aStaticHelloTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		var method = Example.class.getDeclaredMethod("aStaticHello", int.class);
		method.setAccessible(true);
		assertEquals("question 0", method.invoke(null, 0));
	}	

	@Test
	void aStaticHelloTest2() throws Throwable {
		var lookup = MethodHandles.privateLookupIn(Example.class, MethodHandles.lookup());
		assertEquals("question 0", (String) lookup
				.findStatic(Example.class, "aStaticHello", MethodType.methodType(String.class, int.class))
				.invokeExact(0));
		
	}

	
	@Test
	void anInstanceHelloTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		var method = Example.class.getDeclaredMethod("anInstanceHello", int.class);
		method.setAccessible(true);
		assertEquals("question 0", method.invoke(new Example(), 0));
	}

	@Test
	void anInstanceHelloTest2() throws Throwable {
		var lookup = MethodHandles.privateLookupIn(Example.class, MethodHandles.lookup());
		var methodHandle = lookup.findVirtual(Example.class, "anInstanceHello", MethodType.methodType(String.class, int.class));
		assertEquals("question 0", (String) methodHandle.invokeExact(new Example(), 0));
	}

	@Test
	void anInstanceHelloTest3() throws Throwable {
		var lookup = MethodHandles.privateLookupIn(Example.class, MethodHandles.lookup());
		var methodHandle = MethodHandles.insertArguments(
				lookup.findVirtual(Example.class, "anInstanceHello", MethodType.methodType(String.class, int.class)), 1, 8);
		assertEquals("question 8", (String) methodHandle.invokeExact(new Example()));
	}

	@Test
	void anInstanceHelloTest4() throws Throwable {
		var lookup = MethodHandles.privateLookupIn(Example.class, MethodHandles.lookup());
		var methodHandle = MethodHandles.dropArguments(
				lookup.findVirtual(Example.class, "anInstanceHello", MethodType.methodType(String.class, int.class)), 1, int.class);
		assertEquals("question 1", (String) methodHandle.invokeExact(new Example(), 0, 1));
	}

	@Test
	void anInstanceHelloTest5() throws Throwable {
		var lookup = MethodHandles.privateLookupIn(Example.class, MethodHandles.lookup());
		var methodHandle = lookup.findVirtual(Example.class, "anInstanceHello", MethodType.methodType(String.class, int.class));
		var newMethodHandle = methodHandle.asType(MethodType.methodType(String.class, Example.class, Integer.class));
		assertEquals("question 0", (String) newMethodHandle.invokeExact(new Example(), Integer.valueOf(0)));
	}

	@Test
	void constantTest() throws Throwable {
		var methodHandle = MethodHandles.constant(String.class, "0");
		assertEquals("0", (String) methodHandle.invokeExact());
	}

	@Test
	void gwtTest() throws Throwable {
		var test = MethodHandles.publicLookup().findVirtual(String.class, "equals", MethodType.methodType(Boolean.class, Object.class));
		test = MethodHandles.insertArguments(test, 0, "foo");
		var target = MethodHandles.constant(String.class, "1");
		var fallback = MethodHandles.constant(String.class, "-1");
		var gwt = MethodHandles.guardWithTest(test, target, fallback);
		assertEquals("1", (String) gwt.invokeExact("foo"));
		assertEquals("-1", (String) gwt.invokeExact("bar"));
	}

}
