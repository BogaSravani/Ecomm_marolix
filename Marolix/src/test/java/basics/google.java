package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class google {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.google.co.in/");
	driver.findElement(By.className("gLFyf")).sendKeys("selenium");
	List<WebElement> options=driver.findElements(By.xpath("//div[@class='erkvQe']/div[1]/ul[1]/li"));
	System.out.println(options.size());
	for(WebElement opt:options)
	{
		   
		  System.out.println(opt.getText());
		   String i=opt.getText();
		   if(i.contains("selenium uses"))
		   {
			   opt.click();
			   break;
		   }
	}
}
}
