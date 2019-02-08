package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verifyLoginErrorMessages {
	  WebDriver driver;
		@BeforeTest
		public void setUP() {	
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\pinou\\Documents\\QA  tester\\JAVA JAR FILES\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.macys.com/account/signin");
			driver.findElement(By.id("sign-in")).click();
		}
		@Test
		public void verifyLoginEmailMessage() throws Exception {
			
			WebElement emailError=driver.findElement(By.xpath("//small[text()='Please enter your email address']"));
			String message = "Please enter your email address";
			Assert.assertTrue(emailError.isDisplayed());
			Assert.assertEquals(emailError.getText(), message," The Expected and the actual messages are not same");
			
		}
		@Test
		public void verifyLoginPasswordMessage() throws Exception {
							
			WebElement PasswordError =driver.findElement(By.xpath("//small[text()='Please enter your password']"));					
			String message = "Please enter your password";
			Assert.assertTrue(PasswordError.isDisplayed());
			Assert.assertEquals(PasswordError.getText(), message," The Expected and the actual messages are not same");						
		}
		@AfterTest
		public void tearDown() {
		driver.close();
		driver.quit();
		}
}
