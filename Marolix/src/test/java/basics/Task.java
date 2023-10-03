package basics;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class Task {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://testautomationpractice.blogspot.com/");
	driver.findElement(By.cssSelector("#name")).sendKeys("Sravani Boga");
	driver.findElement(By.id("email")).sendKeys("sravanib.marolix@gmail.com");
	driver.findElement(By.id("phone")).sendKeys("6281619490");
	driver.findElement(By.xpath("//div[@class='form-group']/textarea")).sendKeys("Ap");
	driver.findElement(By.cssSelector("[for='female']")).click();
	/**List<WebElement> days=driver.findElements(By.xpath("//input[@type='checkbox'and@id]"));
	for(WebElement day:days)
	{
	  day.click();
	**/
	List<WebElement> days=driver.findElements(By.xpath("//label[@class='form-check-label' and @for]"));
	for(WebElement wb:days)
	{
		 String day=wb.getText();
		 if(day.equalsIgnoreCase("wednesday"))
		 {
			 wb.click();
		 }
	}

}
}


