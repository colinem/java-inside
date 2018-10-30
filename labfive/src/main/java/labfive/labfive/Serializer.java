package labfive;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Serializer {
	
	public static String toJSON(Object o) {
		String body = Arrays.stream(o.getClass().getMethods())
				.filter(m -> m.getName().startsWith("get") && m.getParameterCount() == 0 && m.isAnnotationPresent(JSONProperty.class))
				.map(m -> "  \"" + propertyName(m.getName()) + "\": \"" + methodReturn(m, o) + "\"\n")
				.collect(Collectors.joining());
		return "{\n" + body + "}\n";
	}
	
	private static Object methodReturn(Method m, Object o) {
		try {
			return m.invoke(o);
		} catch (IllegalAccessException e) {
			throw new IllegalStateException(e);
		} catch (InvocationTargetException e) {
			Throwable cause = e.getCause();
			if (cause instanceof RuntimeException)
				throw (RuntimeException) cause;
			if (cause instanceof Error)
				throw (Error) cause;
			throw new UndeclaredThrowableException(cause);
		}
	}

	private static String propertyName(String name) {
		return Character.toLowerCase(name.charAt(3)) + name.substring(4);
    }
	
}
