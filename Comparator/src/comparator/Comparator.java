package comparator;

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
			if (method.getName().startsWith("get") &&
				(method.getParameterCount() == 0) &&
				(method.getReturnType() != void.class) &&
				(!method.isAnnotationPresent(IgnoreInComparison.class))
			) {
				try {
					Object oldValue = method.invoke(oldObject);
					Object newValue = method.invoke(newObject);

					if (method.isAnnotationPresent(Tolerance.class)) {
						double tolerance = method.getAnnotation(Tolerance.class).minDiff();
						double oldNumber = (Double)oldValue;
						double newNumber = (Double)newValue;
						if (Math.abs(oldNumber - newNumber) >= tolerance) {
							addDifference(diffs, method, oldValue, newValue);
						}
					} else if (!oldValue.equals(newValue)) {
						addDifference(diffs, method, oldValue, newValue);
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
		return diffs;
	}

	private static void addDifference(List<Difference> diffs, Method method, Object oldValue, Object newValue) {
		String attributeName = method.getName().substring(3,4).toLowerCase() + method.getName().substring(4);
		diffs.add(new Difference(attributeName, oldValue, newValue));
	}
}