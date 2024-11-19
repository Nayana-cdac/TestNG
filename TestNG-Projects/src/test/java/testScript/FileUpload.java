package testScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class FileUpload extends Base {
	@Test(retryAnalyzer=retry.Retry.class)
	public void sendKeys() {
		driver.navigate().to("https://practice.expandtesting.com/upload#google_vignette");
		WebElement selectpdf = driver.findElement(By.xpath("//input[@id='fileInput']"));// id of 'choose file' button  
		selectpdf.sendKeys("C:\\Users\\nms2\\Downloads\\sample.pdf");// location of file to be uploaded
		WebElement upload = driver.findElement(By.xpath("//button[@id='fileSubmit']"));// upload button
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(upload));
		upload.click();
	}

	@Test
	public void robotClass() throws AWTException {
		driver.navigate().to("https://www.ilovepdf.com/pdf_to_word"); 
 		WebElement selectpdf=driver.findElement(By.xpath("//a[@id='pickfiles']")); 
 		selectpdf.click(); 
 		StringSelection stringselection =new StringSelection("C:\\Users\\nms2\\Downloads\\sample.pdf"); 
 		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null); //line for copy path to clipboard 
 		Robot robot=new Robot(); 
 		robot.delay(2500);  //increase delay like 2500 if wont work 
 		/*robot.keyPress(KeyEvent.VK_ENTER); 
 		robot.keyRelease(KeyEvent.VK_ENTER); */ //no need of these two lines 
 		//keyboard events
 		robot.keyPress(KeyEvent.VK_CONTROL);  //cntrl press key
 		robot.keyPress(KeyEvent.VK_V); //paste ctrl+v  
 		robot.keyRelease(KeyEvent.VK_CONTROL); // release key
 		robot.keyRelease(KeyEvent.VK_V); 
 		robot.keyPress(KeyEvent.VK_ENTER); 
 		robot.keyRelease(KeyEvent.VK_ENTER); 
 	}
	
}
