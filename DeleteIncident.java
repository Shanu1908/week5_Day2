package week5.day2;


	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.testng.annotations.Test;

	public class DeleteIncident extends ServiceBaseClass_Parameters
	{
		@Test()
		public void deleteIncident() throws InterruptedException
		{
			
			WebElement search = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following-sibling::input"));
			search.sendKeys(incNum);
			search.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("sysverb_delete")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("ok_button")).click();
			Thread.sleep(5000);
			WebElement checkIncident = driver.findElement(By.xpath("//table[@id='incident_table']//tr[@class='list2_no_records']/td"));
			String data = checkIncident.getText();
			System.out.println(data);
			if(data.equals("No records to display"))
			{
				System.out.println("Incident Deleted successfully");
			}else {
				System.out.println("Incident not deleted");
			}
		}

	}
