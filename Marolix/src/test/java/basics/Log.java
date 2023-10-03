package basics;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Log {
public static void main(String[] args) throws AWTException {
	WebDriver driver=new ChromeDriver();
	driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfPQzC67XJxy9eoOzVKf8SBXBCVM3Qp83DeWMSyB5jgyICq0Q/viewform");
	driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Sravanib.marolix@gmail.com");
	driver.findElement(By.xpath("//span[contains(@class,'vRMGwf')]")).click();
	driver.findElement(By.xpath("//span[text()='LOG IN']")).click();
	Robot r=new Robot();
	 r.keyPress(KeyEvent.VK_DOWN);
	 r.keyRelease(KeyEvent.VK_DOWN);
	 r.keyPress(KeyEvent.VK_ENTER);
	 r.keyRelease(KeyEvent.VK_ENTER);
}
}
