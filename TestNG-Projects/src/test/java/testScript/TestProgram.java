package testScript;

import org.testng.annotations.Test;

public class TestProgram extends Base {

	@Test(priority=1)
	public void sample() {
		System.out.println("Hi");
	}

	@Test(priority=2)
	public void display() {
		System.out.println("Hello");
	}

}
