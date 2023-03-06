package jot.patternmatching;

public class SwitchPatternMatchingExample {

	public static void twitter(Bird bird) {
 		if (bird instanceof Hummingbird humm ) {
			System.out.println("Hummingburd twitters: "+humm.twitter() );
  		} else if (bird instanceof Thunderbird thunder) {
			System.out.println("Thunderbird twitters: "+thunder.twitter());
  		}
	}
	
	public static void twitterOld(Bird bird) {
		if (bird instanceof Hummingbird) {
			Hummingbird humm = (Hummingbird)bird;
			System.out.println("Hummingbird twitters: "+humm.twitter());
		} else if (bird instanceof Thunderbird ) {
			Thunderbird thunder = (Thunderbird)bird;
			System.out.println("Thunderbird twitters: "+thunder.twitter());
		}
	}
	
	public static void switchTwitter(Bird bird) {
		switch( bird ) {
			case Hummingbird humm -> System.out.println("Hummingbird twitters: "+ humm.twitter() );
			case Thunderbird thunder -> 	System.out.println("Thunderbird twitters: "+thunder.twitter());
		}
	}
	
	public static void switchTwitterForYoungBirds(Bird bird) {
		switch( bird ) {
			case Hummingbird humm when humm.age() < 3 -> System.out.println("Hummingbird twitters: "+ humm.twitter() );
			case Thunderbird thunder when thunder.age() < 5 -> 	System.out.println("Thunderbird twitters: "+thunder.twitter());
			default -> System.out.println("Bird is too old to twitter.");
		}
	}
	
}


sealed interface Bird permits Thunderbird, Hummingbird {
	
	String twitter();
	
	int age();
	
}

final class Hummingbird implements Bird {

	private int age;
	
	public Hummingbird(int age) {
		this.age = age; 
	}
	
	public int age() {
		return age;
	}
	
	public String twitter() {
		return "hummmmm";
	}
}

final class Thunderbird implements Bird {
	
	private int age;
	
	public Thunderbird(int age) {
		this.age = age; 
	}
	
	public int age() {
		return age;
	}

	public String twitter() {
		return "thunder!";
	}

}
