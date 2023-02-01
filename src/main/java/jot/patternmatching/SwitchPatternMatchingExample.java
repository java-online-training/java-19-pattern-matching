package jot.patternmatching;

public class SwitchPatternMatchingExample {

	public static void printGreeting(Employee employee) {

		// employee can be directly checked for type and casted
		switch (employee) {
		
		// the variable can even be used for another boolean expression in a when clause
		case PremiumEmployee pe when pe.getName().equals("Kurt") -> System.out.println(pe.getName() + " is the best!");

		case PremiumEmployee pe -> System.out.println("Hello PremiumEmployee " + pe.getName() + "!");

		case SecondClassEmployee sce -> System.out.println("Hello SecondClassEmployee " + sce.getName() + "!");

		// checking for the super type. The enhanced switch statement must cover all types of the hierarchy.
		// If you miss a type you will get a compile error. 
		case Employee e -> System.out.println("Hello Employee " + e.getName() + "!");
		}
	}

}

// Root of the type hierarchy
class Employee {
	private String name;

	public String getName() {
		return name;
	}

	public Employee(String name) {
		this.name = name;
	}

}

// A subtype
class PremiumEmployee extends Employee {

	public PremiumEmployee(String name) {
		super(name);
	}

}

// Another Subtype
class SecondClassEmployee extends Employee {

	public SecondClassEmployee(String name) {
		super(name);
	}

}
