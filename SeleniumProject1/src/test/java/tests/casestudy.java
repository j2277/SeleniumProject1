package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class casestudy {
	
	WebDriver driver;
	@BeforeTest
	public void beforeTest()
	{
		System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://lkmdemoaut.accenture.com/TestMeApp/fetchcat.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		//driver.findElement(By.id("details-button")).click();
		//driver.findElement(By.id("proceed-link")).click();
	}
	@AfterTest
	public void afterTest()
	{
		
	}
	
	@Test(priority=1)
	public void testRegistration()
	{
		driver.findElement(By.linkText("SignUp")).click();
		driver.findElement(By.id("User Name")).sendKeys("imjo");
		driver.findElement(By.id("First Name")).sendKeys("jo");
		driver.findElement(By.id("Last Name")).sendKeys("aih");
		driver.findElement(By.id("Password")).sendKeys("abc123");
		driver.findElement(By.id("ConfirmPassword")).sendKeys("abc123");
		driver.findElement(By.id("Gender")).click();
		driver.findElement(By.id("Email")).sendKeys("jo@12345.com");
		driver.findElement(By.id("Mobile Number")).sendKeys("9808654322");
		driver.findElement(By.id("DOB")).sendKeys("02/20/1997");
		driver.findElement(By.id("Address")).sendKeys("bangalore");
		driver.findElement(By.id("Email")).sendKeys("jo@12345.com");
		driver.findElement(By.id("Security Question")).sendKeys("411010");
		driver.findElement(By.id("Answer")).sendKeys("bangalore");
		driver.findElement(By.name("Submit")).click();
		String title=driver.getTitle();
		//Assert.assertEquals(text,"Your registration completed");
		Assert.assertEquals(title,"Login");
	}
	@Test(priority=2)
	public void testLogin()
	{
		driver.findElement(By.linkText("SignIn")).click();
		driver.findElement(By.id("userName")).sendKeys("Lalitha");
		driver.findElement(By.id("password")).sendKeys("password123");
		driver.findElement(By.id("Login")).click();
	}
	@Test(priority = 3)
	public void testItemSelection()
	{
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.partialLinkText("All Categories"))).pause(20000).perform();
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Electronics']"))).click().perform();
		act.moveToElement(driver.findElement(By.xpath("//span[text()='Head Phone']"))).click().perform();
		act.moveToElement(driver.findElement(By.linkText("Add to cart"))).click().perform();
	}
	@Test(priority = 3)
	public void testSearchItem()
	{
		driver.findElement(By.id("myInput")).sendKeys("Headphone");
		driver.findElement(By.xpath(".//input[@value='FIND DETAILS']")).click();
		driver.findElement(By.className("btn")).click();
	}
	@Test(priority = 4)
	public void testCart()
	{
		Actions act=new Actions(driver);
		act.click(driver.findElement(By.partialLinkText("Cart"))).click().perform();
		act.click(driver.findElement(By.partialLinkText("Checkout"))).click().perform();
		
	}

	@Test(priority = 5)
	public void testPayment()
	{
		
		Actions act=new Actions(driver);
		act.click(driver.findElement(By.xpath("//input[@value='Proceed to Pay']"))).click().pause(3000).perform();
		String title=driver.getTitle();
		Assert.assertTrue(title.contains("Payment Gateway"));
		driver.findElement(By.xpath("//label[contains(text(),'HDFC Bank')]")).click();
		driver.findElement(By.id("btn")).click();

		driver.findElement(By.name("username")).sendKeys("123457");
		driver.findElement(By.name("password")).sendKeys("Pass@457");
		driver.findElement(By.xpath(".//input[@value='LOGIN']")).click();
		driver.findElement(By.xpath(".//input[@value='PayNow']")).click();
		
	}
}

