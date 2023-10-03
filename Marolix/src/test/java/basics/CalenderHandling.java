package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalenderHandling {
public static void main(String[] args) {
	WebDriver driver=new  FirefoxDriver();
	driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
	//driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
	String month="september";
	String year="2024";
	String date="15";
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,250)");
	driver.findElement(By.id("first_date_picker")).click();
	while(true)
	{
    String monthyear =driver.findElement(By.className("ui-datepicker-title")).getText();	
    String[] month_year=monthyear.split(" ");
    String mnth=month_year[0];
    String yr=month_year[1];
    if(mnth.equalsIgnoreCase(month) && yr.equals(year))
    {
    	break;
    }
    else
    {
    	driver.findElement(By.xpath("//span[text()='Next']")).click();
    	//driver.findElement(By.xpath("//span[text()='Prev']")).click();
    }
	}
	List<WebElement> days=driver.findElements(By.className("ui-state-default"));
	for(WebElement day:days)
	{
		if(day.getText().contains(date))
		{
			day.click();
		}
	}
	
    
}
}
