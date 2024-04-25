package comparator.example;

public class Person {
	private String firstname;
	private String lastname;
	private int age;
	private double weight;
	
	public Person(String firstname, String lastname, int age, double weight) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.weight = weight;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}
}