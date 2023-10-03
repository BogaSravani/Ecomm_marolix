package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo {
@Test
public void m() {
	WebDriver driver=new ChromeDriver();
	driver.get("https://cosmocode.io/automation-practice-webtable/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 
	int row=driver.findElements(By.xpath("//tr")).size();
	System.out.println(row);
	int coloumn=driver.findElements(By.xpath("//tr[1]/td")).size();
	System.out.println(coloumn);
	 
	for(int i=2;i<=row;i++)
	{
		for(int j=2;j<=coloumn;j++)
		{
			String value=driver.findElement(By.xpath("//tr["+i+"]/td["+j+"]")).getText();
			//System.out.println(value);
			if(value.contains("Ottawa"))
			{
		    driver.findElement(By.xpath("//tr["+i+"]//td[1]//input")).click();
				break;
			}
		}
	}
}
}
