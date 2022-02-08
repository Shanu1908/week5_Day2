package week5.day2;



	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;


public class UpdateIncident extends ServiceBaseClass_Parameters
	{
		@BeforeClass
		public void wbName() 
		{
			filename = "EditIncident";
		}
		@Test(dataProvider = "sendData")
		public void editIncident(String note) throws InterruptedException
		{

			WebElement search = driver.findElement(By.xpath("//input[@class='form-control']"));
			search.sendKeys("INC0010020");
			search.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			Thread.sleep(3000);
			WebElement shortNote =driver.findElement(By.id("incident.description"));
			Thread.sleep(2000);
			shortNote.sendKeys(note);
			Thread.sleep(3000);

			
			driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();

		}

	}



