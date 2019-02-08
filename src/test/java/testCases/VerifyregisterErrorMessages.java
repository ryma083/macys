package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyregisterErrorMessages {
    WebDriver driver;
	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pinou\\Documents\\QA  tester\\JAVA JAR FILES\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.macys.com/account/createaccount?cm_sp=my_account-_-sign_in-_-create_account");
		driver.findElement(By.id("ca-profile-submit")).click();
	}

	@Test
	public void verifyRegisterFirstNameMessage() {
		
		WebElement error = driver.findElement(By.id("errormsg-ca-profile-firstname"));
		boolean message =error.isDisplayed();
		String errorMessage = "Please enter your first name.";
		Assert.assertTrue(message);
		Assert.assertEquals(error.getText(), errorMessage," The Expected and the actual messages are not same");
		
	}
	@Test
	public void verifyRegisterLastNameMessage() {
		
		WebElement error =driver.findElement(By.id("errormsg-ca-profile-lastname"));
		boolean message =error.isDisplayed();
		String errorMessage = "Please enter your last name.";
		Assert.assertTrue(message);
		Assert.assertEquals(error.getText(), errorMessage," The Expected and the actual messages are not same");
		
	}
	@Test
	public void verifyRegisterEmailMessage() {
		
		WebElement error =driver.findElement(By.id("errormsg-"));
		boolean message =error.isDisplayed();
		String errorMessage = "Please enter your email address.";
		Assert.assertTrue(message);
		Assert.assertEquals(error.getText(), errorMessage," The Expected and the actual messages are not same");
		
	}
	@Test
	public void verifyRegisterPasswordMessage() {
		
		WebElement error=driver.findElement(By.id("errormsg-ca-profile-password"));
		boolean message =error.isDisplayed();
		String errorMessage = "Please enter a valid password.";
		Assert.assertTrue(message);
		Assert.assertEquals(error.getText(), errorMessage," The Expected and the actual messages are not same");
		
	}
	@Test
	public void verifyRegisterBirthdayMessage() {
		
		WebElement error=driver.findElement(By.id("errormsg-ca-dob"));
		boolean message =error.isDisplayed();
		String errorMessage = "Please enter date of birth.";
		Assert.assertTrue(message);
		Assert.assertEquals(error.getText(), errorMessage," The Expected and the actual messages are not same");		
	}
	
	@AfterClass
	public void tearDown() {
	driver.close();
	driver.quit();
	}	
}
