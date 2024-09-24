package ConstructorInjection;

public class User {
	private int a;
	private int b;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	@Override
	public String toString() {
		return "User [a=" + a + ", b=" + b + "]";
	}
	
	
}