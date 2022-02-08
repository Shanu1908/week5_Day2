package week5.day2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import java.time.Duration;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ServiceBaseClass_Parameters 
{
	private static final String ServiceNowReadExcel = null;
	public ChromeDriver driver;
	public static String incNum;
	public String filename;
	
	@Parameters({"url" ,"username", "password"})
	@BeforeMethod()
	
public void preCondition(String url, String uName, String pwd) throws InterruptedException 
{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("user_name")).sendKeys(uName);
		Thread.sleep(1000);
		driver.findElement(By.id("user_password")).sendKeys(pwd);
		driver.findElement(By.id("sysverb_login")).click();
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("incident");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
		Thread.sleep(3000);
		driver.switchTo().frame("gsft_main");
}
	
@After
public void postcondition () {
driver.close();
}

public void beforeMethod () {

}
}

