package dirk.model;

public class Greeting {

	String name;
	String greeting;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String toString() {
		return "{ \"greeting\": \"" + greeting + "\", \"name\": \"" + name + "\" }";
	}

}
