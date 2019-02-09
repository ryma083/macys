package mento;


import java.util.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;
import org.testng.annotations.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class HandleDropDown {
	WebDriver driver;
	ExtentHtmlReporter rp = null;
	ExtentReports extent = null;
	ExtentTest logger = null;
	
	//this

	@BeforeClass
	public void setUp() {
		  rp = new ExtentHtmlReporter("./target/htmlReport.html");
		  extent = new ExtentReports();		 
		  extent.attachReporter(rp);
		 rp.config().setTheme(Theme.DARK);
		 
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\pinou\\Documents\\QA  tester\\JAVA JAR FILES\\chromedriver.exe");
		
	}
	@BeforeMethod
	public void initi() {
		driver = new ChromeDriver();
		driver.get("http://demoaut.com/");
	}

	@Test (priority=1)
	public void dropdown() {
	    logger=	extent.createTest("dropDownTest");
	
		ArrayList<String> al = new ArrayList<String>();
		driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		WebElement airline = driver.findElement(By.name("airline"));
		Select select = new Select(airline);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			String str = options.get(i).getText();
			System.out.println(str);
			al.add(str);
		}
		System.out.println("*************************************");
		ArrayList<String> reqlist = new ArrayList<String>();
		reqlist.addAll(al);

		Collections.sort(reqlist, Collections.reverseOrder());
		for (String st : reqlist) {
			System.out.println(st);
		}

		Collections.sort(al, Collections.reverseOrder());
		Assert.assertEquals(al, reqlist);
	logger.log(Status.PASS, "the two drop down are identical");
	logger.log(Status.PASS,MarkupHelper.createLabel("test case: dropdown is passed", ExtentColor.GREEN));
		
	}
  @Test(priority=2)
  public void logout() {
	  logger=extent.createTest("logoutTest");
	   driver.findElement(By.name("userName")).sendKeys("mercury");
		driver.findElement(By.name("password")).sendKeys("mercury");
		driver.findElement(By.name("login")).click();
		WebElement ele = driver.findElement(By.linkText("SIGN-OFF"));
		Assert.assertTrue(ele.isDisplayed());
		ele.click();	
		logger.log(Status.PASS, "logout successful!");
		logger.log(Status.PASS, MarkupHelper.createLabel("Test case: logout passed", ExtentColor.GREEN));
  }
 @Test(priority=3)
 public void loginfail() {
	 logger=extent.createTest("loginfail");	 
			driver.findElement(By.name("login")).click();
			WebElement ele = driver.findElement(By.linkText("SIGN-OFF"));			
			Assert.assertTrue(ele.isDisplayed());
			ele.click();
	logger.log(Status.PASS, "login success!");
	logger.log(Status.PASS, MarkupHelper.createLabel("Test case passed", ExtentColor.GREEN));
 }

 @AfterMethod
 public void init(ITestResult result) {
	 if(ITestResult.FAILURE==result.getStatus()) {
      logger.log(Status.FAIL, result.getName());
      logger.log(Status.FAIL, MarkupHelper.createLabel("Test case failed", ExtentColor.RED));
      logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+"test failed", ExtentColor.ORANGE));
	 }else if (ITestResult.SKIP==result.getStatus()) {
	  logger.log(Status.SKIP, MarkupHelper.createLabel("Test case skipped", ExtentColor.YELLOW));
	 }
		extent.flush();
		driver.close();
		driver.quit();

	 
 }
	

}
