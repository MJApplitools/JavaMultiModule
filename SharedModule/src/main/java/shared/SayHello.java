package shared;

public class SayHello {
	
	private String message = "Hello ";
	private String greeting; 
	
	public SayHello(String name) {
		this.greeting = message += name; 
	}
	
	public void printGreeting() {
		System.out.println(this.greeting);
	}

}
