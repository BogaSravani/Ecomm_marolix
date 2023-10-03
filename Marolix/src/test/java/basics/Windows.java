package basics;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	List<WebElement> links=driver.findElements(By.xpath("//div[@class='orangehrm-login-footer-sm']/a"));
	/**for(WebElement link:links)
	{
		 	link.click();
	}**/
	Iterator<WebElement> i=links.iterator();
	while(i.hasNext())
	{
		 WebElement io=i.next();
		 io.click();
	}
	String mainid=driver.getWindowHandle();
	Set<String> ids=driver.getWindowHandles();
	for(String id:ids)
	{
		driver.switchTo().window(id);
		String title=driver.getTitle();
		//System.out.println(title);
	    if(title.contains("Facebook"))
		{
			 driver.findElement(By.id(":rl:")).sendKeys("sr@gmail.com");
		}
	}
	driver.switchTo().window(mainid);
}
}
