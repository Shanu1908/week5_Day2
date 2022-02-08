package week5.day2;

	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;

	public class ServiceNowAssignIncident extends ServiceBaseClass_Parameters
	{
		@BeforeClass
		public void wbName() 
		{
			String filename = "AssignIncident";
		}
		@Test(dataProvider = "sendData")
		public void assignIncident(String group) throws InterruptedException, IOException 
		{
			WebElement search = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following-sibling::input"));
			search.sendKeys("INC0010020");
			search.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']")).click();
			Thread.sleep(3000);
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> windows = new ArrayList<String>(windowHandles);
			driver.switchTo().window(windows.get(1));
			WebElement software = driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input"));
			software.sendKeys(group);
			Thread.sleep(3000);
			software.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//table[@id='sys_user_group_table']//tr[1]/td[3]/a")).click();
			driver.switchTo().window(windows.get(0));
			Thread.sleep(3000);
		
		
		}

	}
