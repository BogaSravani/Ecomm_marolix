package basics;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class calender {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.findElement(By.id("datepicker")).click();
	String month="December";
	String year="2024";
	String date="13";
	while(true)
	{
	String monthyear=driver.findElement(By.className("ui-datepicker-title")).getText();
	 String[] month_year=monthyear.split(" ");
 String mnth=month_year[0];
	String yr=month_year[1];
	if(mnth.equalsIgnoreCase(month)&&yr.equals(year))
	{
		break;
	}
	else  
	{
	//	driver.findElement(By.xpath("//span[text()='Prev']")).click();
		
	driver.findElement(By.xpath("//span[text()='Next']")).click();
	}
	}
}
}
