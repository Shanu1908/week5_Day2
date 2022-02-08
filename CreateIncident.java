package week5.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateIncident extends ServiceBaseClass_Parameters
{
	@BeforeClass
	public void wbName() 
	{
		filename = "CreateIncident";
	}
	@Test(dataProvider = "sendData", priority=1)
	public void createIncident(String name, String notes) throws InterruptedException, IOException 
	{
		driver.findElement(By.id("sysverb_new")).click();
		driver.findElement(By.xpath("//span[@class='icon icon-search']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window1 = new ArrayList<String>(windowHandles);
		driver.switchTo().window(window1.get(1));
		WebElement contactName = driver.findElement(By.xpath("//input[@class='form-control']"));
		contactName.sendKeys(name);
		contactName.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td/a")).click();
		Thread.sleep(1000);
		driver.switchTo().window(window1.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.xpath("//a[@id='lookup.incident.short_description']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> window2 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(window2.get(1));
		driver.findElement(By.xpath("//td/a")).click();
		Thread.sleep(1000);
		driver.switchTo().window(window2.get(0));
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.id("incident.comments")).sendKeys(notes);
		WebElement num = driver.findElement(By.xpath("//input[@id='incident.number']"));
		String incidentNumber = num.getAttribute("value");
		System.out.println("Incident Number : " + incidentNumber);
		driver.findElement(By.id("sysverb_insert_bottom")).click();
		Thread.sleep(2000);
		WebElement search1 = driver.findElement(By.xpath("//input[@class='form-control']"));
		search1.sendKeys(incidentNumber);
		search1.sendKeys(Keys.ENTER);
		Thread.sleep(500);
		incNum = driver.findElement(By.xpath("//td[@class='vt']/a")).getText();
		if(incNum.equals(incidentNumber)) 
		{
			System.out.println("Incident Created");
			File source = driver.getScreenshotAs(OutputType.FILE);
			File destination = new File("./images/CreatedIncident.png");
			FileUtils.copyFile(source, destination);
		}
		else 
		{
			System.out.println("Incident Not Created");
		}
		
	}
}