package comparator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Comparator {
	
	public Comparator() {
		// TODO Auto-generated constructor stub
	}
	
	public static List<Difference> compare(Object oldObject, Object newObject) {
		List<Difference> diffs = new ArrayList<>();

		if (oldObject.getClass() != newObject.getClass()) {
			throw new RuntimeException();
		}

		Class<?> clazz = oldObject.getClass();
		for(Method method : clazz.getMethods()) {
			if (method.getName().startsWith("get") && (method.getParameterCount() == 0) && (method.getReturnType() != void.class)) {
				try {
					Object oldValue = method.invoke(oldObject);
					Object newValue = method.invoke(newObject);
				} catch (IllegalAccessException | InvocationTargetException e) {
					throw new RuntimeException(e);
				}
			}
		}

		return null;
	}
}