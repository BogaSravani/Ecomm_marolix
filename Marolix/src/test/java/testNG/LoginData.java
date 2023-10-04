package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginData {
	WebDriver driver;
	@BeforeMethod
	public void launchbrowser()
	{
		driver=new ChromeDriver();
		driver.get("http://poojastore.marolix.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.linkText("Log In")).click();
	}
	
@Test(dataProvider="user",dataProviderClass=DataPP.class)
 
public void log(String username,String password)
{	 
	driver.findElement(By.name("emailid")).sendKeys(username);
	driver.findElement(By.name("pword")).sendKeys(password);
	driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]")).click();
	String url=driver.getCurrentUrl();
	Assert.assertEquals(url,"http://poojastore.marolix.com/");
}
@AfterMethod
public void teardown()
{
	driver.close();
}
 

}
