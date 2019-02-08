package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GmailLogin {

	WebDriver driver;
	
	@Parameters({"mail","password"})
	@Test()
	public void loginGmailTest(@Optional String email, String psw) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pinou\\Documents\\QA  tester\\JAVA JAR FILES\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.gmail.com/");
		driver.findElement(By.id("identifierId")).sendKeys(email);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("password")).sendKeys(psw);
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(2000);
	    boolean account=driver.findElement(By.xpath("//span[@class='gb_cb gbii']")).isDisplayed();
	    Assert.assertTrue(account);	
		driver.close();
		driver.quit();
	}
}
