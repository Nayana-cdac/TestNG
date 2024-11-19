package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Assertion extends Base {
	 @Test 
	 	public void show() 
	 	{ 
	 		driver.navigate().to("https://www.browserstack.com/"); 
	 		String actualstring=driver.getTitle(); 
	 		System.out.println(actualstring); 
	 		String expected="Most Reliable App & Cross Browser Testing Platform | BrowserStack"; 
	 		Assert.assertEquals(actualstring,expected); 
	 	}
	 @Test 
	 	public void show1() 
	 	{ 
	 		driver.navigate().to("https://www.browserstack.com/"); 
	 		String actualstring=driver.getTitle(); 
	 		System.out.println(actualstring); 
	 		String expected="Most Reliable App & Cross Browser Testing Platform | BrowserStack."; 
	 		Assert.assertNotEquals(actualstring,expected,"same title"); 
	 	}
	 @Test 
	 	public void show2() 
	 	{ 
	 		driver.navigate().to("https://www.browserstack.com/"); 
	 		Boolean verifytitle=driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform | BrowserStack");//ignore upper case lower case only consider content 
	 		Assert.assertTrue(verifytitle); 
	 	}
	 @Test 
	 	public void show3() 
	 	{ 
	 		driver.navigate().to("https://www.browserstack.com/"); 
	 		Boolean verifytitle=driver.getTitle().equalsIgnoreCase("Most Reliable App & Cross Browser Testing Platform | BrowserStack123"); 
	 		Assert.assertFalse(verifytitle); 
	 	}
}
