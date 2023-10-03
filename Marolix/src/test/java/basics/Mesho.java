package basics;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mesho {
public static void main(String[] args){
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.meesho.com/");
	driver.navigate().refresh();
	driver.findElement(By.xpath("//input[contains(@placeholder,'Product')]")).sendKeys("shirts");
	driver.findElement(By.xpath("//input[contains(@placeholder,'Product')]")).click();
	List<WebElement> shirts=driver.findElements(By.xpath("//div[contains(@class,'sc-cOxWqc')]/p"));
	 System.out.println(shirts.size());
	for(WebElement shirt:shirts)
	{
		 
	System.out.println(shirt.getText());
		String se=shirt.getText();
		if(se.contains("shirts for men"))
		{
			shirt.click();
			break;
		}
	}
	 }
}

