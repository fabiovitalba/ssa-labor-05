package comparator.example;

public class ManualComparison {
	public static void main(String[] args) {
		Person p1 = new Person("Eduardo", "Guerra", 39, 110);
		Person p2 = new Person("Eduardo", "Guerra", 43, 120);
		
		// How do I check the difference?
		// I could compare every single attribute:
		if (!p1.getFirstname().equals(p2.getFirstname())) {
			// Add the difference
			// ...
		}
		// ...

		// varArgs example:
		varArgsMethod("fixed", 2, 3, 4);
		varArgsMethod("fixed", new int[]{ 2, 3, 4 });
	}

	//alternative? public static void varArgsMethod(String fixed, int[] varargs) {
	public static void varArgsMethod(String fixed, int... varargs) {
		//varargs[2];
		
	}
}
